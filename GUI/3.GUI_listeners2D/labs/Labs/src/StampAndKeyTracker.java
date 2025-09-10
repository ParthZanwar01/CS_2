import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class StampAndKeyTracker extends JFrame {
    private DrawPanel panel;


    public StampAndKeyTracker() {
        setTitle("Stamps");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new DrawPanel();
        add(panel);


        setVisible(true);
    }


    public static void main(String[] args) {
        new StampAndKeyTracker();
    }


    public static class DrawingPanel {
    }
}


class DrawPanel extends JPanel {
    private ArrayList<Shape> shapes;
    private boolean drawRectangle = true;
    private int thickness = 1;


    public DrawPanel() {
        shapes = new ArrayList<>();
        setBackground(Color.BLACK);


        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    drawRectangle = true;
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    drawRectangle = false;
                }
                addShape(e.getX(), e.getY());
                requestFocusInWindow();
            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                addShape(e.getX(), e.getY());
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }






    private void addShape(int x, int y) {
        if (drawRectangle) {
            shapes.add(new Rectangle(x, y, 50, 50, Color.red, thickness));
        } else {
            shapes.add(new Oval(x, y, 50, 50, Color.BLUE, thickness));
        }
        repaint();
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes) {
            s.draw(g);
        }
    }

}


abstract class Shape {
    int x, y, width, height, thickness;
    Color color;


    public Shape(int x, int y, int width, int height, Color color, int thickness) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.thickness = thickness;
    }


    abstract void draw(Graphics g);
}


class Rectangle extends Shape {
    public Rectangle(int x, int y, int width, int height, Color color, int thickness) {
        super(x, y, width, height, color, thickness);
    }


    void draw(Graphics g) {
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(thickness));
        g2.drawRect(x, y, width, height);
        g2.fillRect(x, y, width, height);
    }
}


class Oval extends Shape {
    public Oval(int x, int y, int width, int height, Color color, int thickness) {
        super(x, y, width, height, color, thickness);
    }


    void draw(Graphics g) {
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(thickness));
        g2.drawOval(x, y, width, height);
        g2.fillOval(x, y, width, height);
    }
}
