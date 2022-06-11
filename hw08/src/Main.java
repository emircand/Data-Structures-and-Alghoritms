public class Main {
    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph();
        Vertex obj_0 = myGraph.newVertex("milk", 1.0);
        obj_0.setColor("white");
        Vertex obj_1 = myGraph.newVertex("tea", 1.0);
        obj_1.setColor("red");
        Vertex obj_2 = myGraph.newVertex("coffee", 1.0);
        obj_2.setColor("brown");
        Vertex obj_3 = myGraph.newVertex("water", 1.0);
        obj_3.setColor("white");
        myGraph.addVertex(obj_0);
        myGraph.addVertex(obj_1);
        myGraph.addVertex(obj_2);
        myGraph.addVertex(obj_3);

        myGraph.addEdge(0, 3, 5.0);
        myGraph.addEdge(3, 0, 5.0);
        myGraph.addEdge(1, 0, 3);
        myGraph.addEdge(3,2,1);
        myGraph.addEdge(2,3, 4);
        myGraph.exportMatrix();

        /*System.out.println();
        myGraph.printGraph();
        /*Vertex two = a.newVertex("b", 1.0);
        Vertex t = a.newVertex("z", 1.0);
        one.setColor("red");
        two.setColor("red");
        a.addVertex(one);
        a.addVertex(two);
        a.addVertex(t);

        a.removeEdge(0,1);
        //a.exportMatrix();
        //a.filterVertices("red", "color");
        a.printGraph();*/
    }
}
