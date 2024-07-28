import java.lang.*;

public class MinimumSpanningTree {

    // Prim's Algorithm

    private static final int vertices = 5;

    int minKey(int[] key, Boolean[] mstSet)
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int vertex = 0; vertex < MinimumSpanningTree.vertices; vertex++)
            if (!mstSet[vertex] && key[vertex] < min) {
                min = key[vertex];
                min_index = vertex;
            }
        return min_index;
    }

    void printMST(int[] parent, int[][] graph)
    {
        System.out.println("Edge\tWeight");
        for (int i = 1; i < vertices; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                    + graph[i][parent[i]]);
    }

    void constructMST(int[][] graph)
    {
        int[] parent = new int[vertices];
        int[] key = new int[vertices];
        Boolean[] mstSet = new Boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < vertices - 1; count++) {

            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < MinimumSpanningTree.vertices; v++)

                if (graph[u][v] != 0 && mstSet[v] == false
                        && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        printMST(parent, graph);
    }

}
