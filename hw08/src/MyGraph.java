import java.util.*;
public class MyGraph implements DynamicGraph{
    private HashMap<Integer, List<Edge>> map;
    private List<Vertex> vertexList;
    int graphIndex;
    int numV;

    /**
     * Constructor of MyGraph class
     */
    MyGraph(){
        map = new HashMap<>();
        vertexList = new ArrayList<Vertex>();
        graphIndex = 0;
        numV = 0;
    }

    /**
     * generate a new vertex by given parameters
     * @param label
     * @param weight
     * @return generated Vertex object
     */
    public Vertex newVertex(String label, double weight){
        Vertex newObj = new Vertex(label, weight, graphIndex++);
        return newObj;
    }

    /**
     * add the given vertex to the graph
     * @param new_vertex vertex to add map and vertexList
     */
    public void addVertex(Vertex new_vertex){
        numV++;
        vertexList.add(new_vertex);
        map.put(new_vertex.getIndex(), new LinkedList<Edge>());
    }

    /**
     * add an edge between the given two vertices in graph
     * @param VertexID1 source
     * @param VertexID2 dest
     * @param weight weight of vertex
     * @return boolean value according to the addition operation
     */
    public boolean addEdge(int VertexID1, int VertexID2, double weight){
        if(VertexID1 == VertexID2){
            System.err.println("same source and dest values");
            return false;
        }
        if(!map.containsKey(VertexID1)){
            System.err.println("graph does not contain given VertexID1");
            return false;
        }
        if(!map.containsKey(VertexID2)){
            System.err.println("graph does not contain given VertexID2");
            return false;
        }
        Edge newEdge = new Edge(VertexID1, VertexID2, weight);

        for (int i = 0; i < map.get(VertexID1).size(); i++) {
            if(map.get(VertexID1).get(i).equals(newEdge)){
                System.out.println("this edge has already added to graph");
                return false;
            }
        }
        insert(newEdge);
        return true;
    }

    /**
     * remove the edge between the given two vertices
     * @param VertexID1 source
     * @param VertexID2 dest
     */
    public void removeEdge(int VertexID1, int VertexID2){
        Edge newEdge = new Edge(VertexID1, VertexID2);
        if(!map.get(VertexID1).remove(newEdge)){
            System.out.println("edge could not found");
        } else {
            System.out.println("[" + VertexID1 + ", " + VertexID2 + "]" + " edge successfully deleted from the graph");
        }
    }

    /**
     * remove the vertex from the graph with respect to the given vertex id
     * @param VertexID
     */
    public void removeVertex(int VertexID){
        for (var element:
             vertexList) {
            if(element.getIndex() == VertexID){
                for (int i = 0; i < vertexList.size(); i++) {
                    for (int j = 0; j < map.get(i).size(); j++) {
                        if(map.get(i).get(j).getSource() == element.getIndex() ||
                                map.get(i).get(j).getDest() == element.getIndex()){
                            map.get(i).remove(j);
                        }
                    }
                }
                vertexList.remove(element);
                map.remove(VertexID);
                numV--;
                System.out.println("Node " + VertexID + " Successfully removed");
                return;
            }
        }
        System.out.println(VertexID + " index couldn't found on the list");
    }

    /**
     * remove the vertex from the graph with respect to the given label from the graph
     * @param label
     */
    public void removeVertex(String label){
        for (var element:
                vertexList) {
            if(element.getLabel().equals(label)){
                for (int i = 0; i < vertexList.size(); i++) {
                    for (int j = 0; j < map.get(i).size(); j++) {
                        if(map.get(i).get(j).getSource() == element.getIndex() ||
                                map.get(i).get(j).getDest() == element.getIndex()){
                            map.get(i).remove(j);
                        }
                    }
                }
                vertexList.remove(element);
                map.remove(element);
                numV--;
                System.out.println("Label " + label + " Successfully removed");
                return;
            }
        }
        System.out.println(label + " label couldn't find on the list");
    }

    /**
     * Filter the vertices by the given user-defined property and returns a subgraph of the graph
     * @param key choosen filter to create subgraph (ex: red or yellow for color filter)
     * @param filter choosen filter type
     */
    public MyGraph filterVertices(String key, String filter){
        MyGraph subGraph = new MyGraph();
        for(var element: vertexList){
            if(element.getColor().equals(key)){
                subGraph.addVertex(element);
            }
        }
        for(var element: subGraph.vertexList){
            for(Edge item: map.get(element.getIndex())){
                if(subGraph.map.containsKey(item.getSource()) && subGraph.map.containsKey(item.getDest())){
                    subGraph.addEdge(item.getSource(), item.getDest(), item.getWeight());
                }
            }
        }
        System.out.println("----------subgraph-----------");
        return subGraph;
    }

    /**
     * generate the adjacency matrix representation of the graph and returns the matrix
     * @return matrix
     */
    public Edge[][] exportMatrix(){
        Edge[][] matrix = new Edge[map.size()][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new Edge[map.get(i).size()];
            for (int j = 0; j < map.get(i).size(); j++) {
                matrix[i][j] = map.get(i).get(j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println("]");
        }
        return matrix;
    }

    /**
     * print the graph in adjacency list format
     */
    public void printGraph(){
        for (var element:
             vertexList) {
            System.out.print(element);
            for(var item: map.get(element.getIndex())){
                System.out.print("-> ");
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    /** Return the number of vertices.
     @return The number of vertices
     */
    @Override
    public int getNumV() {
        return numV;
    }

    /** Determine whether this is a directed graph.
     @return true if this is a directed graph
     */
    @Override
    public boolean isDirected() {

        return false;
    }

    /** Insert a new edge into the graph.
     @param edge The new edge
     */
    @Override
    public void insert(Edge edge) {
        map.get(edge.getSource()).add(edge);
    }

    /** Determine whether an edge exists.
     @param source The source vertex
     @param dest The destination vertex
     @return true if there is an edge from source to dest
     */
    @Override
    public boolean isEdge(int source, int dest) {
        if(source != dest && map.containsKey(source) && map.containsKey(dest))
            return true;
        else return false;
    }

    /** Get the edge between two vertices.
     @param source The source vertex
     @param dest The destination vertex
     @return The Edge between these two vertices
     or an Edge with a weight of
     Double.POSITIVE_INFINITY if there is no edge
     */
    @Override
    public Edge getEdge(int source, int dest) {
        Edge edge = new Edge(source, dest);
        if(isEdge(source, dest) && map.containsKey(edge))
            return edge;
        else return null;
    }

    /** Return an iterator to the edges connected
     to a given vertex.
     @param source The source vertex
     @return An Iterator<Edge> to the vertices
     connected to source
     */
    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return null;
    }
}
