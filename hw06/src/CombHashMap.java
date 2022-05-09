public class CombHashMap <K, V> implements KWHashMap<K, V>{
    private Entry<K, V>[] table;
    private double LOAD_THRESHOLD = 0.75;
    private int numKeys;
    private int numDeletes;
    private final Entry<K, V> DELETED = new Entry<>(null, null);
    private int primeNumber;
    private int tableSize = 10;

    /**
     * display method for table
     */
    public void printTable()
    {
        System.out.println("index | key | value | next");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + " - ");
            if(table[i] != null && table[i].getValue() != null){
                System.out.print(table[i].getKey() + " - " + table[i].getValue() + " - ");
            }
            if(table[i] != null && table[i].nextIndex != -1 ){
                System.out.print(table[i].getNextIndex());
            }
            System.out.println();
        }
    }

    /** Contains key value pairs for a hash table. */
    private static class Entry<K, V> {
        /** The key */
        private final K key;
        /** The value */
        private V value;
        /** colliding item*/
        private int nextIndex = -1;
        /** Creates a new key value pair.
         * @param key The key @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * getter method for nextIndex value
         * @return nextIndex data field of current Entry
         */
        public int getNextIndex() {
            return nextIndex;
        }

        /** Retrieves the key. @return The key
         */
        public K getKey() {
            return key;
        }
        /** Retrieves the value. @return The value
         */
        public V getValue() {
            return value;
        }
        /** Sets the value. @param val The new value @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }

    /**
     * Constructor method for CombHashMap class
     */
    public CombHashMap(){
        numKeys = 0;
        numDeletes = 0;
        table = new Entry[tableSize];
        primeFinder();
    }

    /**
     * double hashing helper method which returns an index value
     * @param key to get hashCode
     * @return an index value from table
     */
    private int Hash1(K key){
        return (int) key % tableSize;
    }

    /**
     * double hashing helper method which returns an index value
     * @param key to get hashCode
     * @return an index value from table
     */
    private int Hash2(K key){
        return primeNumber - ((int) key % primeNumber);
    }

    /**
     * Double hashing method to get Index value
     * @param key to get hashCode
     * @param probeIndex index number of the probe
     * @return an index value from table
     */
    public int HashIndex(K key, int probeIndex){
        return (Hash1(key) + (probeIndex * Hash2(key))) % tableSize;
    }

    /**
     * find next prime number to get new primeNumber
     */
    private void primeFinder() {
        for (int i = (int) (0.8 * tableSize) - 1; i > 1; i--) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primeNumber = i;
            }
        }
    }

    /**
     * check number whether it is prime or not
     * @param number an integer value to check
     * @return if it is prime return true; otherwise return false
     */
    private boolean isPrime(int number){
        for (int i = 2; i <= number/2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * find next prime number
     * @param number an integer start value
     * @return number if it is prime; otherwise make recursive call
     */
    private int nextPrime(int number){
        if(isPrime(number)){
            return number;
        }
        return nextPrime(number+1);
    }

    /** Method get for class HashtableChain.
     * @param key The key being sought
     * @return The value associated with this key if found; otherwise, null
     */
    @Override
    public V get(Object key) {
        if(isEmpty())
            return null;
        int probeIndex = 0;
        int index = HashIndex((K) key, probeIndex);
        if (index < 0)
            index += table.length;
        if(table[index] == null){
            return null;
        }
        do{
            if(table[index].getKey() == key){
                return table[index].getValue();
            } else if(table[index].nextIndex != -1){
                index = HashIndex((K) key, probeIndex++);
            } else {
                return null;
            }
        }while(true);
    }

    /**
     * Returns true if this table contains no key value mappings
     * */
    public boolean isEmpty(){
        if(numKeys <= 0)
            return true;
        else return false;
    }

    /**
     * find empty place if doubleHashing gives nonempty space
     * @return empty place on table
     */
    private int FindEmptyPlace(int probeIndex, K key){
        int result = HashIndex(key, probeIndex);
        if(table[result].getKey() == key){

        }
        if(table[result] != null){
            return FindEmptyPlace(probeIndex+1, key);
        }
        else{
            if(probeIndex > 0){
                int preResult = HashIndex(key, probeIndex-1);
                table[preResult].nextIndex = result;
            }
            return result;
        }
    }

    /** Method put for class HashtableChain.
     * @post This key value pair is inserted in the table and numKeys is incremented.
     * If the key is already in the table, its value is changed to the argument value and numKeys is not changed.
     * @param key The key of item being inserted
     * @param value The value for this key
     * @return The old value associated with this key if found; otherwise, null
     */
    @Override
    public V put(K key, V value){
        int probeIndex = 0;
        while(table[HashIndex(key, probeIndex)] != null){
            if(table[HashIndex(key, probeIndex)] != null && table[HashIndex(key, probeIndex)].getKey() == key){
                return table[HashIndex(key, probeIndex)].setValue(value);
            }
            probeIndex++;
        }
        int result = HashIndex(key, probeIndex);
        int preIndex = HashIndex(key, probeIndex-1);
        if(probeIndex > 1){
            table[preIndex].nextIndex = result;
        }
        if(table[result] == null){
            table[result] = new Entry<>(key, value);
            numKeys++;
            check();
        }
        return null;
    }

    /**
     * if load factor is larger than threshold then call rehash
     */
    public void check(){
        if ((numKeys + numDeletes) > (LOAD_THRESHOLD * tableSize)){
            rehash();
        }
    }

    /**
     * rehash table and increase size of the table
     */
    private void rehash( )
    {
        Entry<K,V>[] oldTable = table;
        tableSize = nextPrime(tableSize*2);
        primeFinder();
        table = new Entry[tableSize];
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if(oldTable[i] != null && oldTable[i] != DELETED)
                put(oldTable[i].getKey(), oldTable[i].getValue());
        }

    }

    /**
     * Removes the mapping for this key from this table if it is present (optional operation).
     * Returns the previous value associated with the specified key,
     * or null if there was no mapping*/
    public V remove(Object key){
        int probeIndex = 0;
        int result = HashIndex((K) key, probeIndex);
        if(result < 0){
            result += table.length;
        }
        while(table[result] != null){
            if(table[result].getKey() == key){
                V oldValue = table[result].getValue();
                recursiveSwap(result,HashIndex((K) key, probeIndex-1));
                numDeletes++;
                numKeys--;
                return oldValue;
            }
            probeIndex++;
            result = HashIndex((K) key, probeIndex);
        }
        return null;
    }

    /**
     * recursive swap method to link elements each other, after removal
     * @param i index
     * @param pre preIndex
     */
    public void recursiveSwap(int i, int pre){
        if(table[i].nextIndex == -1){
            if(table[pre] != null)
                table[pre].nextIndex = -1;
            table[i] = DELETED;
            return;
        }
        int temp = table[i].nextIndex;
        table[i] = new Entry<>(table[temp].getKey(), table[temp].getValue());
        table[i].nextIndex = temp;

        recursiveSwap(temp, i);
    }

    /**
     * returns the size of the table*/
    public int size(){
        return numKeys + numDeletes;
    }
}
