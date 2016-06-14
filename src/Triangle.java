import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;


public class Triangle extends Frame {
    
    public Triangle() {
        setGui();
    }

    public void paint(Graphics g){
        g.setColor(Color.red);
        g.drawLine(50, 50, 100, 100);
        System.out.println("Test!");
    }
    

    private void setGui() {
        setTitle("Triangle");
        setBounds(450, 100, 500, 500);
        setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Triangle myTriangle = new Triangle();
    }

}
 
