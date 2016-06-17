import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Triangle extends JPanel {
	private Dimension screenSize;
	int height;
	int width;
	int layer = 1;
	Color colours = new Color(255, 255, 255);

	
	
	public void setColours(Color colours) {
		this.colours = colours;
	}

	public Dimension getScreenSize() {
		return screenSize;
	}

	@Override
	public void paint(Graphics g) {
		Polygon pol = new Polygon();
//		colours = new Color(255, 255, 255);
		for (int i = 1; i <= 100; i++) {
			// left, top, right
			int[] xcoords = { 0+i*2, width / 2+i*10, width };
			int[] ycoords = { height+i*2, 0, height };
			pol.addPoint(10*i,6);
			pol.addPoint(50,60);
			pol.addPoint(80,74);
			
			
			g.fillPolygon(xcoords, ycoords, xcoords.length);
//			g.fillPolygon(pol);
			g.setColor(colours);
		}
		
		
		if (layer < 27) {
			layer *= 3;
			System.out.println(layer);
			paint(g);
		}

	}

	public Triangle() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		height = (int) screenSize.getHeight();
		width = (int) screenSize.getWidth();
	}

	public void createTriangle(Triangle tri, Color colour) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(tri);
		Dimension sizes = tri.getScreenSize();
		frame.setSize(sizes);
//		frame.setBackground(Color.RED);
		frame.setVisible(true);
		setColours(colour);

	}

	public void drawTheTriangles() {

	}

	public static void main(String[] args) {
		Triangle butz = new Triangle();
		butz.createTriangle(butz, new Color(255, 0, 0));
//		butz.createTriangle(butz, new Color(0, 255, 255));

	}

}