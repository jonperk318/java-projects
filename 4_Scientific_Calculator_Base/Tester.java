import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Input int #1: ");
        int num1 = sc.nextInt();

        System.out.println("Input int #2: ");
        int num2 = sc.nextInt();

        ScientificCalculator calc = new ScientificCalculator(num1, num2);

        // Calling all methods
        System.out.println("Add: " + calc.add());
        System.out.println("Subtract " + calc.subtract());
        System.out.println("Multiply: " + calc.multiply());
        System.out.println("Divide: " + calc.divide());
        System.out.println("Square root: " + calc.squareRoot());
        System.out.println("Exponent: " + calc.exponent());
    }
}