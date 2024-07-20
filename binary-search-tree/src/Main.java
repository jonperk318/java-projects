import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // INITIAL TEST

        int[] testArr = {1, 5, 10, 1, 3, 2, 25, 1, 9, 8}; // array to test BST
        String[] testArrData = {"one", "five", "ten", "one", "three", "two", "twenty-five", "one", "nine", "eight"};
        BinarySearchTree test = new BinarySearchTree();

        for (int i = 0; i < testArr.length; i++) { // insert testArr into BST
            test.insert(testArr[i], testArrData[i]);
        }
        System.out.println();
        System.out.print("Inorder traversal of test BST: ");
        test.inorder(); // print sorted testArr
        System.out.println();

        System.out.print("Searching for data from key 5 in test BST: ");
        test.search(5);

        System.out.println();
        System.out.print("Inorder traversal of test BST after deleting key 5: ");
        test.delete(5);
        test.inorder();
        System.out.println();


        // BUILD BST USING INPUT DATA

        // read input data from CSV file and put keys and data into two arrays

        Scanner sc = new Scanner(new File("./UPC.csv"));

        ArrayList<Long> keyInput = new ArrayList<>();
        ArrayList<String> dataInput = new ArrayList<>();

        readInput input = new readInput(sc, keyInput, dataInput);

        Collections.shuffle(keyInput, new Random(0)); // shuffle so input is not sorted
        Collections.shuffle(dataInput, new Random(0));

        BinarySearchTree tree = new BinarySearchTree();

        for (int i = 0; i < keyInput.size(); i++) { // create BST
            tree.insert(keyInput.get(i), dataInput.get(i));
        }

        /*
        System.out.print("Inorder traversal of BST: ");
        tree.inorder();
        System.out.println();
         */

        System.out.print("Searching for data from key 161 in BST: ");
        tree.search(161);
        System.out.println();

        // read test keys from input file

        ArrayList<Long> testKeyInput = new ArrayList<>();
        ArrayList<String> testDataInput = new ArrayList<>();
        sc = new Scanner(new File("input.dat"));

        readInput testInput = new readInput(sc, testKeyInput, testDataInput);

        //for (int i = 0; i < testKeyInput.size(); i++) {}
    }

    public static class readInput {
       Scanner sc;
       ArrayList<Long> keyInput = new ArrayList<>();
       ArrayList<String> dataInput = new ArrayList<>();
       public readInput(Scanner sc, ArrayList<Long> keyInput, ArrayList<String> dataInput) {
           this.sc = sc;
           this.keyInput = keyInput;
           this.dataInput = dataInput;
       }

       while (sc.hasNextLine()) { // read input.dat line by line

            String line = sc.nextLine();
            String[] splitLine = line.split(",", 2); // key before first comma, data after
            String data;
            if (String.valueOf(splitLine[1].charAt(0)).equals(",")) { // remove commas at the beginning of sentences
                data = splitLine[1].substring(1);
            }
            else {
                data = splitLine[1].replaceFirst(",", ", ");
            }
            keyInput.add(Long.parseLong(splitLine[0]));
            dataInput.add(data);
        }
    }
}