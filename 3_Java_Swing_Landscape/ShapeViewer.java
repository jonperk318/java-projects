import javax.swing.*;
import java.awt.*;

public class ShapeViewer {
	public static void main(String[] args) {
		// EventQueue.invokerLater reveal the graphics after everything has loaded
		// Without this, graphics may not appear properly!
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// use this frame object to add 2D objects to
					JFrame frame = new JFrame();

					// add objects into your frame
					ShapeComponent s = new ShapeComponent();

					//JSlider slider  = s.getSlider();

					// configure your frame's size, title, and close operation
					frame.setSize(800, 600);
					frame.setLocationRelativeTo(null); // center frame
					frame.setTitle("Rural Autumn Landscape");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					frame.add(s);

					//JPanel panel = new JPanel();
					//panel.setOpaque(false);
					//panel.add(slider);
					//frame.add(panel);

					// Name
					//JLabel nameLabel = new JLabel("Jonathan Perkins ", JLabel.CENTER);
					//Color berry = Color.decode("#842c5c");
					//nameLabel.setForeground(berry);
					//nameLabel.setFont(new Font("MV Boli", Font.BOLD, 15));
					//nameLabel.setHorizontalAlignment(JLabel.RIGHT);
					//nameLabel.setVerticalAlignment(JLabel.BOTTOM);
					//frame.add(nameLabel);

					//ImageIcon minecraftGrass = new ImageIcon("grass.webp");
					//JLabel grassLabel = new JLabel();
					//JLabel.setIcon(minecraftGrass);

					//JLayeredPane pane = frame.getLayeredPane();
					//pane.setLayout(null);
					//pane.setPreferredSize(new Dimension(s.getWidth(), s.getHeight()));
					//pane.add(nameLabel, 2);
					//pane.add(s, 1);

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}