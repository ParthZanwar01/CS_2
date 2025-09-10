
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

public class BlockContainsVisualizer extends JFrame {

    DrawingPanel dp = new DrawingPanel();
    Block block = new Block(100, 100, 300, 300);
    Point p = new Point();
    final int SIZE = 500;

    public BlockContainsVisualizer() {
        init();
        setTitle("Block Contains Visualizer");
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void init() {
        block.setColor(Color.yellow);
        dp.setPreferredSize(new Dimension(SIZE, SIZE));
        dp.setBackground(Color.BLACK);
        dp.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseMovedMotion(e);
            }
        });
        add(dp);
    }

    private void mouseMovedMotion(MouseEvent e) {
        p.setLocation(e.getX(), e.getY());
        repaint();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(BlockContainsVisualizer::new);
    }

    private class DrawingPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (block.contains(p.x, p.y)) {
                block.setColor(Color.PINK);
                block.draw(g);
                g.setColor(Color.YELLOW);
                g.fillOval(p.x - 6, p.y - 6, 12, 12);
            } else {
                block.setColor(Color.YELLOW);
                block.draw(g);
            }
            g.setColor(Color.RED);
            g.fillOval(p.x - 4, p.y - 4, 8, 8);
        }
    }
}
