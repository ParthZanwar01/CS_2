import javax.swing.*;
import java.awt.*;

public class Drawing extends JFrame {

    public Drawing() {
        setTitle("Drawing");
        setSize(new Dimension(300, 300));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new DrawingPanel());

        //centers the frame
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Drawing();
    }

    private class DrawingPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();
            int lines = 17;// update
            int dx = 0;// update
            int dy = h-h/lines;// update

            // your code goes here
            for (int i = 1; i <= lines; i++){
                g.drawLine(0, 0, dx, dy);
                g.drawLine(dx,dy,w,h);
                g.drawLine(0,h, w-dx, dy);
                g.drawLine(w, 0, w-dx, dy);
                dx+=w/lines;
                dy-=h/lines;
            }
        }
    }
}
