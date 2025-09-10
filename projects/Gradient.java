import javax.swing.*;
import java.awt.*;


public class Gradient extends JFrame {

    public Gradient(){
        setTitle("Gradient");
        setBackground(Color.white);
        graphicspanel gp = new graphicspanel();
        getContentPane().add(gp);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	setResizable(false);
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Gradient();
    }
}/*
class GraphicsPanel extends JPanel
{

  public GraphicsPanel()
  {
      setPreferredSize(new Dimension(800, 600));
  }

  public void paintComponent(Graphics g)
  {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gp1 = new GradientPaint(25, 25, Color.blue, 15, 25, Color.black, true);

        g2d.setPaint(gp1);
        g2d.fillRect(20, 20, getWidth(), getHeight());
  }
}*/