import java.util.LinkedList;
import java.util.Arrays;

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
        int nodes, edges;
        LinkedList<Edge> [] adjacencyList;

        Graph(int nodes, int edges) {
            this.nodes = nodes;
            this.edges = edges;
            adjacencyList = new LinkedList[nodes];

            for (int i = 0; i < nodes ; i++) { // initialize an adjacency lists for every node
                adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, double weight) {
            adjacencyList[source].add(new Edge(source, destination, weight)); // add edge to node on adjacency list
        }

        public void printGraph(){

            for (int i = 0; i < nodes; i++) {

                LinkedList<Edge> list = adjacencyList[i];

                for (Edge edge : list) {
                    System.out.println("Node " + edge.source + " is connected to node " +
                            edge.destination + " with weight " + edge.weight);
                }
            }
        }

        public int getNodes() {
            return this.nodes;
        }

        public int getEdges() {
            return this.edges;
        }

        public void primMST() { // Prim's algorithm for a Minimum Spanning Tree

            boolean[] selected = new boolean[nodes]; // array to track selected node
            Arrays.fill(selected, false); // selected node becomes true, all else are false
            selected[0] = true; // start with the first node

            int numberOfEdges = 0; // number of edges will always be < (nodes - 1)
            System.out.println("Edge\t\tWeight");

            while (numberOfEdges < nodes - 1) {

                // find all adjacent nodes, calculate distance from initial node (selected[0]),
                // discard if already in the set, otherwise choose another node closest to initial node

                double min = Double.MAX_VALUE; // to find minimum weight
                int x = 0; // row number
                int y = 0; // column number

                for (int i = 0; i < nodes; i++) {

                    if (selected[i]) {

                        for (int j = 0; j < adjacencyList[i].size(); j++) {

                            //if (!selected[j]) { // node is not selected and has an edge
                            for (Edge edge : adjacencyList[i]) {

                                if (edge.destination == adjacencyList[i].get(j).source) {

                                    if (!selected[j]) { // node is not in selected set and has an edge

                                        if (min > adjacencyList[i].get(j).weight) {

                                            min = adjacencyList[i].get(j).weight;
                                            x = i;
                                            y = j;
                                        }
                                    }

                                }
                            }


                        }
                    }
                }
                System.out.println(adjacencyList[x].get(y).source + " - " + adjacencyList[x].get(y).destination
                        + "\t\t" + adjacencyList[x].get(y).weight);
                selected[y] = true;
                numberOfEdges++;
            }
        }
    }
}
