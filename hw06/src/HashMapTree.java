public class HashMapTree<K extends Comparable<K>, V> implements KWHashMap<K, V>{
    private BinaryTree<Entry<K, V>>[] table;
    private int numKeys;
    private static final int CAPACITY = 8;
    private static final double LOAD_THRESHOLD = 3.0;

    /**
     * display table on the console
     */
    public void printTable()
    {
        for (int i = 0; i < table.length; i++) {
            System.out.print("index " + i + " - ");
            if(table[i] != null && table[i].root != null)
                if(table[i].getData().getValue() != null)
                    System.out.print(table[i].getData().getKey() + " - " + table[i].getData().getValue() );
            System.out.println();
        }
    }

    /** Contains key value pairs for a hash table. */
    private static class Entry<K, V> {
        /** The key */
        private final K key;
        /** The value */
        private V value;
        /** Creates a new key value pair.
         * @param key The key @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
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

    public HashMapTree(){
        table = new BinaryTree[CAPACITY];
    }

    /** Method get for class HashtableChain.
     * @param key The key being sought
     * @return The value associated with this key if found; otherwise, null
     */
    @Override
    public V get(Object key) {
        if(isEmpty())
            return null;

        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null;
        BinaryTree<Entry<K,V>> item = table[index];
        while(true){
            if(item == null)
                return null;
            else if(item.getData().getKey().equals(key))
                return item.getData().getValue();
            else if(item.getData().getKey().compareTo((K) key) < 0)
                item = item.getLeftSubtree();
            else item = item.getRightSubtree();
        }
    }

    /**
     * Returns true if this table contains no key value mappings
     * */
    public boolean isEmpty(){
        if(numKeys <= 0)
            return true;
        else return false;
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
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            // Create a new BST at table[index].
            table[index] = new BinaryTree<>();
        }
        // Search the list at table[index] to find the key.
        BinaryTree<Entry<K,V>> item = table[index];
        while(true){
            if(item == null || item.root == null){
                item.root = new BinaryTree.Node<>(new Entry<>(key, value));
                check();
                return null;
            }
            else if(item.getData().getKey().equals(key)){
                return item.getData().setValue(value);
            }
            else if(item.getData().getKey().compareTo((K) key) < 0)
                item = item.getLeftSubtree();
            else
                item = item.getRightSubtree();
        }
    }

    /**
     * if numKeys value is larger than load factor, then call rehash() method
     */
    private void check(){
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length))
            rehash();
    }

    /**
     * rehash table and increase size of the table
     */
    private void rehash( )
    {
        BinaryTree<Entry<K, V>>[] oldTable = table;
        table = new BinaryTree[2 * table.length];
        for (int i = 0; i < table.length; i++) {
            table[i] = new BinaryTree<>();
        }
        for (int i = 0; i < oldTable.length; i++) {
            table[i] = oldTable[i];
        }
    }

    /**
     * Removes the mapping for this key from this table if it is present (optional operation).
     * Returns the previous value associated with the specified key,
     * or null if there was no mapping*/
    public V remove(Object key){
        /*
        * Algorithm for HashtableChain.remove(Object key)
        * 1. Set index to key.hashCode() % table.length.
        * 2. if index is negative, add table.length.
        * 3. if table[index] is null
        * 4.key is not in the table; return null. --
        * 5. Search the list at table[index] to find the key.
        * 6. if the search is successful
        * 7.Remove the entry with this key and decrement numKeys.
        * 8. if the list at table[index] is empty Set table[index] to null.
        * 9. Return the value associated with this key.
        * 10. The key is not in the table; return null*/
        int index = key.hashCode() % table.length;
        if(index < 0 ){
            index += table.length;
        }
        if(table[index] == null){
            return null;
        }
        BinaryTree<Entry<K,V>> item = table[index];
        while(true){
            if(item.root == null){
                return null;
            } else if(item.getData().getKey().equals(key)){
                return item.getData().setValue(null);
            } else if(item.getData().getKey().compareTo((K) key) < 0)
                item = item.getLeftSubtree();
            else item = item.getRightSubtree();
        }
    }

    /**
     * returns the size of the table*/
    public int size(){
        return numKeys;
    }
}
