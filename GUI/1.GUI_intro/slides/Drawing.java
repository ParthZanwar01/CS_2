import java.awt.*;
import javax.swing.*;
public class Drawing extends JFrame {

    public Drawing() {
    	setTitle("Four Corners");
    	setSize(new Dimension(300,300));
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	add(new DrawingPanel());
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new Drawing();
    }
    private class DrawingPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			int width = getWidth();
			int height = getHeight();
			g.drawLine(0,0,width,height);
			g.drawLine(width,0,0, height);
		}
    }
}
