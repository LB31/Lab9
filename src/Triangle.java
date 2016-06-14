import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Triangle extends JPanel {

	public void paint(Graphics g) {
		
	      int[] xcoords = {150, 270, 30};
	      int[] ycoords = {180, 350, 350};
	      g.setColor (Color.GREEN);
	      g.fillPolygon (xcoords, ycoords, xcoords.length);

	}
	
	public Triangle(){
		
	}
	

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Triangle());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize);
		frame.setVisible(true);
	}

}
