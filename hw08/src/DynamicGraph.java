public interface DynamicGraph extends Graph{
    /**
     * generate a new vertex by given parameters
     * @param label
     * @param weight
     * @return generated Vertex
     */
    public Vertex newVertex(String label, double weight);

    /**
     * add the given vertex to the graph
     * @param new_vertex
     */
    public void addVertex(Vertex new_vertex);

    /**
     *add an edge between the given two vertices in graph
     */
    public boolean addEdge(int VertexID1, int VertexID2, double weight);

    /**
     * remove the edge between the given two vertices
     * @param VertexID1 source index
     * @param VertexID2 dest index
     */
    public void removeEdge(int VertexID1, int VertexID2);

    /**
     * remove the vertex from the graph with respect to the given vertex id
     * @param VertexID index value for removal
     */
    public void removeVertex(int VertexID);

    /**
     * remove the vertex from the graph with respect to the given label from the graph
     * @param label given label to delete
     */
    public void removeVertex(String label);

    /**
     * Filter the vertices by the given user-defined property and returns a subgraph of the graph
     * @param key
     * @param filter
     */
    public MyGraph filterVertices(String key, String filter);

    /**
     * generate the adjacency matrix representation of the graph and returns the matrix
     * @return
     */
    public Edge[][] exportMatrix();

    /**
     * print the graph in adjacency list format
     */
    public void printGraph();



}
