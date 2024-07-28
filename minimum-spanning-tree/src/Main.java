import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // TEST
        // read tinyDG.txt to a weighted graph

        WeightedGraph.Graph tinyDG = fileToWeightedGraph("tinyDG.txt");
        tinyDG.printGraph();
        System.out.println(tinyDG.nodes);

    }

    public static WeightedGraph.Graph fileToWeightedGraph(String inputFile) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(inputFile));

        int first = sc.nextInt();

        // second integer is the number of edges
        int edges = sc.nextInt();

        WeightedGraph.Graph output = new WeightedGraph.Graph(edges);

        while (sc.hasNextLine()) { // add all the edges
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            String[] splitLine = line.split(" ");
            output.addEgde(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]),
                    Double.parseDouble(splitLine[2]));
        }

        return output;

    }

}