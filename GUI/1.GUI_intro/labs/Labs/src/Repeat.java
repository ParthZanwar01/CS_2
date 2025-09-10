import javax.swing.*;
import java.awt.*;


public class Repeat extends JFrame{

    static int num;
    public Repeat() {
        String s = JOptionPane.showInputDialog(null, "Enter 1 to draw rectangles\nEnter 2 to draw circles");
        num = Integer.parseInt(s);
        setTitle("Repeat Shapes");
        setSize(new Dimension(300, 300));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new DrawingPanel());

        //centers the frame
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Repeat();
    }

    private class DrawingPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();
            int lines = 10;// update
            int dx = 50;// update
            int dy = 50;// update
            int rectWidth = 25;
            int rectHeight = 25;
            // your code goes here
            for (int i = 1; i <= lines; i++){
                if (num == 1){
                    g.drawRect(dx, dy, rectWidth, rectHeight);
                    dx+=rectWidth/2;
                    dy+=rectHeight/2;
                    rectWidth+=10;
                    rectHeight+=10;
                }
                else if (num == 2){
                    g.drawOval(dx, dy, rectWidth, rectHeight);
                    dx+=rectWidth/3;
                    dy+=rectHeight/3;
                    rectWidth+=10;
                    rectHeight+=10;
                }
            }
        }
    }
}
