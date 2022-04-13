public interface SearchTree <E> {
    /**
     * Inserts item where it belongs in the tree.
     * Returns true if item is inserted;
     * false if it isn’t (already in tree)
     * */
    public boolean add(E item);

    /**
     * Returns true if target is found in the tree
     * */
    public boolean contains(E target);

    /**
     * Returns a reference to the data in the node that is equal to target.
     * If no such node is found, returns null
     * */
    public E find(E target);

    /**
     * Removes target (if found) from tree and returns it; otherwise, returns null
     * */
    public E delete(E target);

    /**
     * Removes target (if found) from tree and returns true; otherwise, returns false
     * */
    public boolean remove(E target);
}
