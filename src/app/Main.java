public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println("Граф:");
        graph.printGraph();

        System.out.println("Чи існує вершина 1: " + graph.hasVertex(1));
        System.out.println("Чи існує ребро 1-2: " + graph.hasEdge(1, 2));

        graph.removeEdge(1, 2);
        System.out.println("Після видалення ребра 1-2:");
        graph.printGraph();

        graph.removeVertex(3);
        System.out.println("Після видалення вершини 3:");
        graph.printGraph();
    }
}