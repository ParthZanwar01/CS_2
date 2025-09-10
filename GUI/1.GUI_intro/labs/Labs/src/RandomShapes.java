import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class RandomShapes extends JFrame{


    public RandomShapes() {
        setTitle("Random Shapes");
        setSize(new Dimension(300, 300));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new DrawingPanel());

        //centers the frame
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new RandomShapes();
    }

    private class DrawingPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();
            int shapes = 10;// update
            Random r = new Random();
            // your code goes here
            for (int i = 1; i <= shapes; i++){
                boolean shape = Math.random() < 0.5;
                Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
                g.setColor(c);
                int xPos = r.nextInt(w);
                int yPos = r.nextInt(h);
                int width = r.nextInt(w-w/2);
                int height = r.nextInt(h-h/2);
                if (shape){
                    g.fillRect(xPos, yPos, width, height);
                } else {
                    g.fillOval(xPos, yPos, width, height);
                }
            }
        }
    }
}
