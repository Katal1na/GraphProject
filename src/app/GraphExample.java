import java.util.*;

public class GraphExample {

    public static void main(String[] args) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        addVertex(graph, 1);
        addVertex(graph, 2);
        addVertex(graph, 3);

        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);

        System.out.println("Граф:");
        printGraph(graph);

        System.out.println("Чи існує вершина 1: " + hasVertex(graph, 1));
        System.out.println("Чи існує ребро 1-2: " + hasEdge(graph, 1, 2));

        removeEdge(graph, 1, 2);
        System.out.println("Після видалення ребра 1-2:");
        printGraph(graph);

        removeVertex(graph, 3);
        System.out.println("Після видалення вершини 3:");
        printGraph(graph);
    }

    public static void addVertex(Map<Integer, Set<Integer>> graph, int vertex) {
        graph.putIfAbsent(vertex, new HashSet<>());
    }

    public static void addEdge(Map<Integer, Set<Integer>> graph, int v1, int v2) {
        graph.putIfAbsent(v1, new HashSet<>());
        graph.putIfAbsent(v2, new HashSet<>());

        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    public static void removeVertex(Map<Integer, Set<Integer>> graph, int vertex) {
        if (!graph.containsKey(vertex)) return;

        for (int v : graph.keySet()) {
            graph.get(v).remove(vertex);
        }

        graph.remove(vertex);
    }

    public static void removeEdge(Map<Integer, Set<Integer>> graph, int v1, int v2) {
        if (graph.containsKey(v1)) {
            graph.get(v1).remove(v2);
        }
        if (graph.containsKey(v2)) {
            graph.get(v2).remove(v1);
        }
    }

    public static boolean hasVertex(Map<Integer, Set<Integer>> graph, int vertex) {
        return graph.containsKey(vertex);
    }

    public static boolean hasEdge(Map<Integer, Set<Integer>> graph, int v1, int v2) {
        return graph.containsKey(v1) && graph.get(v1).contains(v2);
    }

    public static void printGraph(Map<Integer, Set<Integer>> graph) {
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            int vertex = entry.getKey();
            Set<Integer> neighbors = entry.getValue();

            for (int neighbor : neighbors) {
                if (vertex <= neighbor) {
                    System.out.println(vertex + " -- " + neighbor);
                }
            }
        }
    }
}