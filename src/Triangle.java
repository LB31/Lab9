import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class Triangle extends JPanel {
	
	
	public void paint(Graphics g) {
		g.drawLine(50, 100, 0, 50);
//		g.setColor(Color.red);
//		g.drawLine(50, 50, 10, 94);
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Triangle());
		frame.setSize(300, 200);
		frame.setVisible(true);
	}

}
