import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // TEST
        // read tinyDG.txt to a weighted graph

        WeightedGraph.Graph tinyDG = fileToWeightedGraph("tinyDG.txt");
        System.out.println("tinyDG has " + tinyDG.getNodes() + " nodes and " + tinyDG.getEdges() + " edges.");
        tinyDG.printGraph();
        tinyDG.primMST();

        // PRIM'S ALGORITHM

        WeightedGraph.Graph mediumDG = fileToWeightedGraph("mediumDG.txt");
        WeightedGraph.Graph largeDG = fileToWeightedGraph("largeDG.txt");
        WeightedGraph.Graph XtraLargeDG = fileToWeightedGraph("XtraLargeDG.txt");

        // RECORDING MST TIME

        double[] times = new double[4];

        double tick = System.nanoTime();
        tinyDG.primMST();
        double tock = System.nanoTime();
        times[0] = ((tock - tick) / 1_000_000_000);

        tick = System.nanoTime();
        mediumDG.primMST();
        tock = System.nanoTime();
        times[1] = ((tock - tick) / 1_000_000_000);

        tick = System.nanoTime();
        largeDG.primMST();
        tock = System.nanoTime();
        times[2] = ((tock - tick) / 1_000_000_000);

        tick = System.nanoTime();
        XtraLargeDG.primMST();
        tock = System.nanoTime();
        times[3] = ((tock - tick) / 1_000_000_000);

        System.out.println("Times (in seconds): ");
        for (double time : times) {
            System.out.println(time + ", ");
        }

    }

    public static WeightedGraph.Graph fileToWeightedGraph(String inputFile) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(inputFile));

        int nodes = sc.nextInt();
        sc.nextLine();

        // second integer is the number of edges
        int edges = sc.nextInt();
        sc.nextLine();

        WeightedGraph.Graph output = new WeightedGraph.Graph(nodes, edges);

        while (sc.hasNextLine()) { // add all the edges
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            String[] splitLine = line.trim().split(" +");
            output.addEgde(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]),
                    Double.parseDouble(splitLine[2]));

        }

        return output;

    }

}