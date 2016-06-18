import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Triangle extends JPanel {

	private Dimension screenSize;
	private int screenHeight;
	private int screenWidth;

	public void paint(Graphics g) {

		screenSize = this.getSize();
		screenHeight = (int) screenSize.getHeight();
		screenWidth = (int) screenSize.getWidth();

		int[] xcoords = { 0, screenWidth, (screenWidth) / 2 };
		int[] ycoords = { screenHeight, screenHeight, 0 };
		g.setColor(Color.GREEN);
		g.fillPolygon(xcoords, ycoords, xcoords.length);

		drawRecursiveTriangle(screenWidth, screenHeight, g);

	}

	public Triangle() {
		screenSize = null;
		screenHeight = 0;
		screenWidth = 0;
	}

	private void drawRecursiveTriangle(int screenWidth, int screenHeight, Graphics g) {

		if (screenHeight != 0 && screenWidth != 0) {
			int[] xcoords2 = { screenWidth / 4, screenWidth - (screenWidth / 4), (screenWidth) / 2 };
			int[] ycoords2 = { screenHeight / 2, screenHeight / 2, screenHeight };
			g.setColor(Color.BLUE);
			g.fillPolygon(xcoords2, ycoords2, xcoords2.length);

			drawRecursiveTriangle(screenWidth / 2, screenHeight / 2, g);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Triangle());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize);
		frame.setVisible(true);
	}

}
