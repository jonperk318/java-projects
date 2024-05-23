import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ShapeComponent extends JComponent implements ChangeListener {

	private JSlider slider = new JSlider(200, 265, 200);

	public void paintComponent(Graphics g) {

		int w = getWidth(), h = getHeight();

		// add slider
		JLabel label = new JLabel();
		JSlider slider = this.slider;

		slider.setPreferredSize(new Dimension(200, 100));
		// slider.setOrientation(SwingConstants.VERTICAL);
		slider.addChangeListener(this);
		slider.setOpaque(false);

		slider.setPaintTrack(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);

		// Colors
		Color navy = Color.decode("#230d33");
		Color white = Color.decode("#d9dad8");
		Color houseSide = Color.decode("#a9a9a9");
		Color doorColor = Color.decode("#cf807a");
		Color trunk = Color.decode("#704021");
		Color red = Color.decode("#bb2034");
		Color maroon = Color.decode("#8e0f1d");
		Color berry = Color.decode("#842c5c");
		Color orange = Color.decode("#d17204");
		Color gold = Color.decode("#e5ac3b");
		Color yellow = Color.decode("#f7ca46");
		Color grass = Color.decode("#e2bf84");
		Color darkGrass = Color.decode("#374f3f");
		Color sage = Color.decode("#969f83");
		Color darkSage = Color.decode("#938a5d");
		float skyHue1 = 0.555f;
		float skyHue2 = 0.67f;
		float saturation = 0.9f; //1.0 for brilliant, 0.0 for dull
		float luminance = 1.0f; //1.0 for brighter, 0.0 for black
		Color skyColor1 = Color.getHSBColor(skyHue1, saturation, luminance);
		Color skyColor2 = Color.getHSBColor(skyHue2, saturation, luminance);

		// Casts g as a Graphics2D object, allows us to draw/fill with shape objects
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		GradientPaint gp = new GradientPaint(0, 0, skyColor1, w, h, skyColor2);
		g2.setPaint(gp);
		g2.fillRect(0, 0, w, h);

		// GRASS
		g2.setPaint(grass);
		g2.fillRect(0, h*2/3, w, h*2/3);

		//for (int i = 0; i < 10; i+=10) {
		//	g2.drawImage(minecraftGrass, i, h*2/3 - 10);
		//}

		// Trees
		Random rand = new Random();
		for (int i = 0; i < w; i += 15) {
			int color = rand.nextInt(0, 6);
			if (color == 0) {
				createTree(i, h*2/3, trunk, red, g2);
			}
			if (color == 1) {
				createTree(i, h*2/3, trunk, maroon, g2);
			}
			if (color == 2) {
				createTree(i, h*2/3, trunk, berry, g2);
			}
			if (color == 3) {
				createTree(i, h*2/3, trunk, orange, g2);
			}
			if (color == 4) {
				createTree(i, h*2/3, trunk, gold, g2);
			}
			if (color == 5) {
				createTree(i, h*2/3, trunk, yellow, g2);
			}
		}

		// GRASS

		for (int i = 0; i < w; i += 15) {
			int color = rand.nextInt(0,3);
			if (color == 0) {
				createGrass(i, h*3/4, darkGrass, g2);
			}
			if (color == 1) {
				createGrass(i, h*3/4, yellow, g2);
			}
			if (color == 2) {
				createGrass(i, h*3/4, sage, g2);
			}
			if (color == 3) {
				createGrass(i, h*3/4, darkSage, g2);
			}
		}
		for (int i = 0; i < w; i += 15) {
			int color = rand.nextInt(0,3);
			if (color == 0) {
				createGrass(i, h*5/6, darkGrass, g2);
			}
			if (color == 1) {
				createGrass(i, h*5/6, yellow, g2);
			}
			if (color == 2) {
				createGrass(i, h*5/6, sage, g2);
			}
			if (color == 3) {
				createGrass(i, h*5/6, darkSage, g2);
			}
		}
		for (int i = 0; i < w; i += 15) {
			int color = rand.nextInt(0,3);
			if (color == 0) {
				createGrass(i, h-40, darkGrass, g2);
			}
			if (color == 1) {
				createGrass(i, h-40, yellow, g2);
			}
			if (color == 2) {
				createGrass(i, h-40, sage, g2);
			}
			if (color == 3) {
				createGrass(i, h-40, darkSage, g2);
			}
		}

		g2.setStroke(new BasicStroke(3));

		// HOUSE
		// Front
		int[] xList1 = {w/3, w/2, w/2, w*5/12, w/3};
		int[] yList1 = {h*2/3, h*2/3, h*7/12, h/2, h*7/12};
		g2.setPaint(navy);
		g2.drawPolygon(xList1, yList1, 5);
		g2.setPaint(white);
		g2.fillPolygon(xList1, yList1, 5);
		// Side
		g2.setPaint(navy);
		g2.drawRect(w/6, h*7/12, w/6, h/12);
		g2.setPaint(houseSide);
		g2.fillRect(w/6, h*7/12, w/6, h/12);
		// Roof
		g2.setPaint(navy);
		int[] xList2 = {w/6 - 15, w/3, w*5/12, w*5/12 - w/6};
		int[] yList2 = {h*7/12, h*7/12, h/2, h/2};
		g2.fillPolygon(xList2, yList2, 4);
		// Chimney
		g2.setPaint(white);
		g2.fillRect(w*5/12 - 5, h/2 - 20, 10, 25);
		// Door
		g2.setPaint(navy);
		g2.drawRect(w*5/12 - 10, h*2/3 - 30, 20, 30);
		g2.setPaint(doorColor);
		g2.fillRect(w*5/12 - 10, h*2/3 - 30, 20, 30);
		// Front Windows
		g2.setStroke(new BasicStroke(1));
		createWindow(w*17/48, h*14/24, 20, 40, g2, navy, skyColor1, skyColor2);
		createWindow(w*22/48, h*14/24, 20, 40, g2, navy, skyColor1, skyColor2);
		// Side Windows
		createWindow(w*9/48 + 3, h*29/48, 20, 20, g2, navy, skyColor1, skyColor2);
		createWindow(w*11/48 + 3, h*29/48, 20, 20, g2, navy, skyColor1, skyColor2);
		createWindow(w*13/48 + 3, h*29/48, 20, 20, g2, navy, skyColor1, skyColor2);

		// Trees

		// Name
		g2.setColor(berry);
		g2.drawString("Jonathan Perkins", w - 120, h - 10);


	}
	public void createWindow(int x, int y, int w, int h, Graphics2D g2, Color frame, Color color1, Color color2) {
		GradientPaint gp = new GradientPaint(x, y, color1, x+w, y+h, color2);
		g2.setPaint(gp);
		g2.fillRect(x, y, w, h);
		g2.setColor(frame);
		g2.drawRect(x, y, w, h);
		g2.drawRect(x, y, w/2, h);
		g2.drawRect(x + w/4, y, w/2, h);
	}

	public void createTree(int x, int y, Color trunk, Color leaves, Graphics2D g2) {
		Random rand = new Random();
		int h = rand.nextInt(70, 120);
		g2.setColor(trunk);
		g2.fillRect(x, y - h/2, h/16, h/2);
		g2.setColor(leaves);
		g2.fillOval(x - h/2, y - h, h*2/3, h*2/3);
		//g2.fillOval(x - h, y - h - h/2, h/2, h/2);
	}

	public void createGrass(int x, int y, Color color, Graphics2D g2) {
		Random rand = new Random();
		int h = rand.nextInt(30, 60);
		int offset1 = rand.nextInt(-5, 5);
		int offset2 = rand.nextInt(-5, 5);
		int xNew = x + offset1;
		int yNew = y + offset2;
		g2.setColor(color);
		g2.fillOval(xNew, yNew, h, h);
	}

	public JSlider getSlider() {
		return slider;
	}
	private static final long serialVersionUID = 1L;

	@Override
	public void stateChanged(ChangeEvent e) {

	}
}
