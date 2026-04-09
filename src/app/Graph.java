import java.util.*;

public class Graph {

    private Map<Integer, Set<Integer>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    // a. Додати вершину
    public void addVertex(int vertex) {
        graph.putIfAbsent(vertex, new HashSet<>());
    }

    // b. Додати ребро
    public void addEdge(int source, int destination) {
        graph.putIfAbsent(source, new HashSet<>());
        graph.putIfAbsent(destination, new HashSet<>());

        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    // c. Видалити вершину
    public void removeVertex(int vertex) {
        if (!graph.containsKey(vertex)) return;

        // Видаляємо всі зв'язки з цією вершиною
        for (Set<Integer> neighbors : graph.values()) {
            neighbors.remove(vertex);
        }

        graph.remove(vertex);
    }

    // d. Видалити ребро
    public void removeEdge(int source, int destination) {
        if (graph.containsKey(source)) {
            graph.get(source).remove(destination);
        }
        if (graph.containsKey(destination)) {
            graph.get(destination).remove(source);
        }
    }

    // e. Перевірка вершини
    public boolean hasVertex(int vertex) {
        return graph.containsKey(vertex);
    }

    // f. Перевірка ребра
    public boolean hasEdge(int source, int destination) {
        return graph.containsKey(source) &&
                graph.get(source).contains(destination);
    }

    // Вивід графа
    public void printGraph() {
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            int vertex = entry.getKey();
            Set<Integer> neighbors = entry.getValue();

            for (int neighbor : neighbors) {
                if (vertex <= neighbor) { // щоб не дублювати
                    System.out.println(vertex + " -- " + neighbor);
                }
            }
        }
    }
}