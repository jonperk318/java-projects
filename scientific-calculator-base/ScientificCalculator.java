import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ScientificCalculator extends Calculator {

    public ScientificCalculator(int num1, int num2) {
        super(num1, num2);
    }

    public double squareRoot() {
        return sqrt(getNum1());
    }

    public int exponent() {
        return (int) pow(getNum1(), getNum2());
    }

}
