import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    // frame object for 2D objects
                    JFrame frame = new JFrame();

                    // add objects into the frame
                    Shapes s = new Shapes();
                    frame.add(s);

                    // configure frame size, title, and close operation
                    frame.setSize(s.getFrameLength() + 5, s.getFrameLength() + 35);
                    frame.setLocationRelativeTo(null);  // center window
                    frame.setTitle("4 Shapes");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}