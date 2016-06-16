import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Triangle extends JPanel {
	private Dimension screenSize;
	int height;
	int width;
	int layer = 1;
	Color colours = new Color(255,255,255);

	public Dimension getScreenSize() {
		return screenSize;
	}
	
	@Override
	public void paint(Graphics g) {

		for (int i = 1; i <= layer; i++) {
			// left, top, right 
			int[] xcoords = { 0, width / 2, width };
			int[] ycoords = { height, 0, height };
			g.setColor(colours);
			g.fillPolygon(xcoords, ycoords, xcoords.length);
		}
		layer *= 3;
		System.out.println(layer);
		if (layer <= 27)
			paint(g);

	}

	public Triangle() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		height = (int) screenSize.getHeight();
		width = (int) screenSize.getWidth();
	}

	public void createTriangle(Triangle tri) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(tri);
		Dimension sizes = tri.getScreenSize();
		frame.setSize(sizes);
		frame.setBackground(Color.RED);
		frame.setVisible(true);

	}

	public void drawTheTriangles() {

	}

	public static void main(String[] args) {
		Triangle butz = new Triangle();
		butz.createTriangle(butz);

	}

}