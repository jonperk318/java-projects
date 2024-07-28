import java.util.LinkedList;

public class WeightedGraph {

    public static class Edge {
        int source;
        int destination;
        double weight;

        public Edge(int source, int destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static class Graph {
        int nodes;
        LinkedList<Edge> [] adjacencyList;

        Graph(int nodes) {
            this.nodes = nodes;
            adjacencyList = new LinkedList[nodes];

            for (int i = 0; i < nodes ; i++) { // initialize an adjacency lists for every node
                adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, double weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencyList[source].addFirst(edge); // for directed graph
        }

        public void printGraph(){
            for (int i = 0; i < nodes; i++) {
                LinkedList<Edge> list = adjacencyList[i];
                for (Edge edge : list) {
                    System.out.println("Vertex " + i + " is connected to " +
                            edge.destination + " with weight " + edge.weight);
                }
            }
        }
    }
}
