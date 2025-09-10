
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

public class BlockUnionVisualizer extends JFrame {

    DrawingPanel dp = new DrawingPanel();
    Block blockA = new Block(100, 100, 300, 150);
    Block blockB = new Block(400, 350, 200, 100);
    boolean a_dragged, b_dragged;
    int oldX, oldY;
    final int SIZE = 900;

    public BlockUnionVisualizer() {
        init();
        setTitle("Block Union Visualizer");
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void init() {
        blockA.setColor(Color.blue);
        blockB.setColor(Color.green);
        dp.setPreferredSize(new Dimension(SIZE, SIZE));
        dp.setBackground(Color.BLACK);
        dp.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mouseDraggedMotion(e);
            }
        });

        dp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                oldX = me.getX();
                oldY = me.getY();
                if (blockA.contains(me.getX(), me.getY())) {
                    a_dragged = true;
                } else if (blockB.contains(me.getX(), me.getY())) {
                    b_dragged = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                mouseMoved(me);
                a_dragged = false;
                b_dragged = false;
            }
        });
        add(dp);
    }

    private void mouseDraggedMotion(MouseEvent e) {

        int x_diff = oldX - e.getX();
        int y_diff = oldY - e.getY();
        if (a_dragged) {
            blockA.setPos(blockA.getX() - x_diff, blockA.getY() - y_diff);
        } else if (b_dragged) {
            blockB.setPos(blockB.getX() - x_diff, blockB.getY() - y_diff);
        }
        oldX = e.getX();
        oldY = e.getY();
        repaint();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(BlockUnionVisualizer::new);
    }

    private class DrawingPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Block union = blockA.union(blockB);
            union.setColor(Color.red);
            g.setColor(Color.yellow);
            g.fillRect(union.getX() - 2, union.getY() - 2, union.getWidth() + 4, union.getHeight() + 4);
            union.draw(g);

            blockA.draw(g);
            blockB.draw(g);

        }
    }
}
