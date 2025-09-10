import javax.swing.*;
import java.awt.*;


public class Spiral {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Spiral Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new SpiralPanel());
        frame.setVisible(true);
    }
}


class SpiralPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        Graphics2D g2d = (Graphics2D) g;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int step = 20;
        int length = 20;
        int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        g2d.setColor(Color.BLACK);
        int x = centerX;
        int y = centerY;
        int direction = 0;


        for (int i = 0; i < 50; i++) {
            int nextX = x + directions[direction][0] * length;
            int nextY = y + directions[direction][1] * length;
            g2d.drawLine(x, y, nextX, nextY);
            x = nextX;
            y = nextY;
            direction = (direction + 1) % 4; // Change direction
            if (direction == 1 || direction == 3) {
                length += step;
            }
        }
    }
}
