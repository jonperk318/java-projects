import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JComponent;

public class Shapes extends JComponent {

    private final int frameLength = 700;
    public int getFrameLength() {
        return this.frameLength;
    }

    Random rand = new Random();

    public void paintComponent(Graphics g) {

        // Randomly generated colors
        float hue1 = rand.nextFloat();
        float hue2 = rand.nextFloat();
        float hue3 = rand.nextFloat();
        float hue4 = rand.nextFloat();
        float saturation = 0.9f;//1.0 for brilliant, 0.0 for dull
        float luminance = 1.0f; //1.0 for brighter, 0.0 for black
        Color color1 = Color.getHSBColor(hue1, saturation, luminance);
        Color color2 = Color.getHSBColor(hue2, saturation, luminance);
        Color color3 = Color.getHSBColor(hue3, saturation, luminance);
        Color color4 = Color.getHSBColor(hue4, saturation, luminance);

        // Casts g as a Graphics2D object, allows us to draw/fill with shape objects
        Graphics2D g2 = (Graphics2D) g;

        // Create a shape
        //Rectangle2D.Double r = new Rectangle2D.Double(50, 50, 100, 100);

        g2.setColor(Color.BLACK);
        g2.drawRect(frameLength/2, 0, frameLength/2, frameLength/2);
        g2.drawRect(0, 0, frameLength/2, frameLength/2);
        g2.drawRect(0, frameLength/2, frameLength/2, frameLength/2);
        g2.drawRect(frameLength/2, frameLength/2, frameLength/2, frameLength/2);

        int n1 = rand.nextInt(25, 100);
        int n2 = rand.nextInt(25, 100);
        int n3 = rand.nextInt(25, 100);
        int n4 = rand.nextInt(25, 100);

        randShape(frameLength/2, frameLength, 0, frameLength/2, n1, color1, g2);
        randShape(0, frameLength/2, 0, frameLength/2, n2, color2, g2);
        randShape(0, frameLength/2, frameLength/2, frameLength, n3, color3, g2);
        randShape(frameLength/2, frameLength, frameLength/2, frameLength, n4, color4, g2);

    }

    public void randShape(int xLow, int xHi, int yLow, int yHi, int n, Color color, Graphics2D g2) {

        int shape = rand.nextInt(0,4);
        int x = rand.nextInt(xLow + 5, xHi - (n*2) - 5);
        int y = rand.nextInt(yLow + 5, yHi - (n*2) - 5);

        // SQUARE
        if (shape == 0) {
            g2.setColor(Color.BLACK);
            g2.drawRect(x, y, n, n);
            g2.setColor(color);
            g2.fillRect(x, y, n, n);
        }

        // CIRCLE
        if (shape == 1) {
            g2.setColor(Color.BLACK);
            g2.drawOval(x, y, n*2, n*2);
            g2.setColor(color);
            g2.fillOval(x, y, n*2, n*2);
        }

        // RECTANGLE
        if (shape == 2) {
            g2.setColor(Color.BLACK);
            g2.drawRect(x, y, n*2, n);
            g2.setColor(color);
            g2.fillRect(x, y, n*2, n);
        }

        // EQUILATERAL TRIANGLE
        if (shape == 3) {
            g2.setColor(Color.BLACK);
            double h = (n * Math.sqrt(3)) / 2; // height of triangle
            int y1 = y + (int) h;
            int x2 = x + n;
            int y2 = y + (int) h;
            int x3 = x + (n/2);
            int[] xList = {x, x2, x3};
            int[] yList = {y1, y2, y};
            g2.drawPolygon(xList, yList, 3);
            g2.setColor(color);
            g2.fillPolygon(xList, yList, 3);
        }
    }

    private static final long serialVersionUID = 1L;

}
