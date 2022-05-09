public interface KWHashMap<K, V> {
    /**
     * Returns the value associated with the specified key. Returns null if the key is not
     * present
     */
    public V get(Object key);

    /**
     * Returns true if this table contains no key value mappings
     * */
    public boolean isEmpty();

    /**
     *  Associates the specified value with the specified key.
     *  Returns the previous value associated with the specified key,
     *  or null if there was no mapping for the key*/
    public V put(K key, V value);

    /**
     * Removes the mapping for this key from this table if it is present (optional operation).
     * Returns the previous value associated with the specified key,
     * or null if there was no mapping*/
    public V remove(Object key);

    /**
     * returns the size of the table*/
    public int size();
}
