import javax.swing.*;
import java.awt.*;

public class Drawing2 extends JFrame {

    public Drawing2() {
        setTitle("Drawing2");
        setSize(new Dimension(300, 300));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new DrawingPanel2());

        //centers the frame
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Drawing2();
    }

    private class DrawingPanel2 extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();
            int lines = 17;
            int dx = w-w/lines;
            int dy = h/lines;

            for (int i = 1; i <= lines; i++){
                g.drawLine(dx,0,0, dy);
                g.drawLine(dx,h,w, dy);
                g.drawLine(w-dx,0,w,dy);
                g.drawLine(w-dx,h,0, dy);
                dx-=w/lines;
                dy+=h/lines;

            }
        }
    }
}
