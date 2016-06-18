import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TriangleEli extends JPanel {

	private Dimension screenSize;
	private int screenHeight;
	private int screenWidth;
	private int depth = 7;

	public void paint(Graphics g) {

		screenSize = this.getSize();
		screenHeight = (int) screenSize.getHeight();
		screenWidth = (int) screenSize.getWidth();

		int[] xcoords = { 0, screenWidth, (screenWidth) / 2 };
		int[] ycoords = { screenHeight, screenHeight, 0 };
		g.setColor(Color.GREEN);
		g.fillPolygon(xcoords, ycoords, xcoords.length);

//		drawRecursiveTriangle(screenWidth, screenHeight, g);
		
	    subTriangle
	    (
	      1, //This represents the first recursion
	      (0 + screenWidth) / 2, //x coordinate of first corner
	      (screenHeight + screenHeight) / 2, //y coordinate of first corner
	      (0 + (screenWidth / 2)) / 2, //x coordinate of second corner
	      (screenHeight + 0) / 2, //y coordinate of second corner
	      (screenWidth + (screenWidth / 2)) / 2, //x coordinate of third corner
	      (screenHeight + 0) / 2,  //y coordinate of third corner
	      g,
	      Color.RED
	    );
		

	}

	public TriangleEli() {
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
	
	
	public void subTriangle(int n, float x1, float y1, float x2, float y2, float x3, float y3, Graphics g, Color colour)
	{
	  //Draw the 3 sides as black lines
		int[] xcoords = { (int) x1, (int) x2, (int) x3 };
		int[] ycoords = { (int) y1, (int) y2, (int) y3 };
		g.setColor(colour);
		g.fillPolygon(xcoords, ycoords, xcoords.length);

	  //Calls itself 3 times with new corners, but only if the current number of recursions is smaller than the maximum depth
	  if(n < depth)
	  {
	    //Smaller triangle 1
	    subTriangle
	    (
	      n+1, //Number of recursions for the next call increased with 1
	      (x1 + x2) / 2 + (x2 - x3) / 2, //x coordinate of first corner
	      (y1 + y2) / 2 + (y2 - y3) / 2, //y coordinate of first corner
	      (x1 + x2) / 2 + (x1 - x3) / 2, //x coordinate of second corner
	      (y1 + y2) / 2 + (y1 - y3) / 2, //y coordinate of second corner
	      (x1 + x2) / 2, //x coordinate of third corner
	      (y1 + y2) / 2,  //y coordinate of third corner
	      g,
	      Color.BLUE
	    );
	    //Smaller triangle 2
	    subTriangle
	    (
	      n+1, //Number of recursions for the next call increased with 1
	      (x3 + x2) / 2 + (x2 - x1) / 2, //x coordinate of first corner
	      (y3 + y2) / 2 + (y2 - y1) / 2, //y coordinate of first corner
	      (x3 + x2) / 2 + (x3 - x1) / 2, //x coordinate of second corner
	      (y3 + y2) / 2 + (y3 - y1) / 2, //y coordinate of second corner
	      (x3 + x2) / 2, //x coordinate of third corner
	      (y1 + y2) / 2,  //y coordinate of third corner
	      g,
	      Color.GREEN
	    );
	    //Smaller triangle 3
	    subTriangle
	    (
	      n+1, //Number of recursions for the next call increased with 1
	      (x1 + x3) / 2 + (x3 - x2) / 2, //x coordinate of first corner
	      (y1 + y3) / 2 + (y3 - y2) / 2, //y coordinate of first corner
	      (x1 + x3) / 2 + (x1 - x2) / 2, //x coordinate of second corner
	      (y1 + y3) / 2 + (y1 - y2) / 2, //y coordinate of second corner
	      (x1 + x3) / 2, //x coordinate of third corner
	      (y1 + y2) / 2,  //y coordinate of third corner
	      g,
	      Color.YELLOW
	    );
	  }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new TriangleEli());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize);
		frame.setVisible(true);
	}

}