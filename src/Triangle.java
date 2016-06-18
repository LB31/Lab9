import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Triangle extends JPanel {
	private Dimension screenSize;
	int height;
	int width;
	int layer = 1;
	Color colours = new Color(255, 0, 0);
	int[] left = new int[2];
	int[] middle = new int[2];
	int[] right = new int[2];
	int[] leftTemp = new int[2];
	int[] middleTemp = new int[2];
	int[] rightTemp = new int[2];
	Polygon pol = new Polygon();

	public Dimension getScreenSize() {
		return screenSize;
	}

	@Override
	public void paintComponent(Graphics g) {
//super.paintComponent(g);
//if(layer == 1)
		calculateTriangle();

		

//		int[] xcoords = { left[0], middle[0], right[0] };
//		int[] ycoords = { left[1], middle[1], right[1] };

		
		pol.addPoint(left[0], left[1]);
		pol.addPoint(middle[0], middle[1]);
		pol.addPoint(right[0], right[1]);
		
		
//		System.out.println(xcoords[1]);
//		System.out.println(ycoords[1]);
		
		
		g.setColor(colours);
		g.drawPolygon(pol);
//		g.drawPolygon(xcoords, ycoords, xcoords.length);

//		layer++;
		
		// if (layer < 2) {
		//
		// // System.out.println(layer);
		// layer++;
		// paint(g);
		//
		// }

	}
	
	public void calculateTriangle(){
		leftTemp = findMidpoint(left, middle);
		middleTemp = findMidpoint(left, right);
		rightTemp = findMidpoint(right, middle);
		
		left = leftTemp;
		middle = middleTemp;
		right = rightTemp;
		
		
	}
	

	public int[] findMidpoint(int[] first, int[] second) {
		int newX;
		int newY;

		newX = (first[0] + second[0]) / 2;
		newY = (first[1] + second[1]) / 2;

		System.out.println(newX);
		System.out.println(newY);
		int[] newPoint = { newX, newY };

		return newPoint;

	}

	public Triangle() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		height = (int) screenSize.getHeight();
		width = (int) screenSize.getWidth();

		left[0] = 0;
		left[1] = height;
		middle[0] = width / 2;
		middle[1] = 0;
		right[0] = width;
		right[1] = height;

	}

	public void createTriangle(Triangle tri) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(tri);
		Dimension sizes = tri.getScreenSize();
		frame.setSize(sizes);
		// frame.setBackground(Color.RED);
		frame.setVisible(true);

	}

	public void drawTheTriangles() {

	}

	public static void main(String[] args) {
		Triangle butz = new Triangle();
		butz.createTriangle(butz);

	}

}