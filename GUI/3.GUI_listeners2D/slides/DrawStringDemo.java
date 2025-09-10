/*
 * DrawStringDemo.java
 */
//package drawstringdemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.*;

public class DrawStringDemo extends JFrame
{

  static GraphicsPanel stringPanel = new GraphicsPanel();

  public static void main(String args[])
  {
    //construct frame
    new DrawStringDemo().show();
  }

  public DrawStringDemo()
  {
    // create frame
    setTitle("drawString Demo");
    setResizable(false);
    addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent e)
      {
        exitForm(e);
      }
    });
    getContentPane().setLayout(new GridBagLayout());

    // position controls (establish event methods)
    GridBagConstraints gridConstraints = new GridBagConstraints();
    stringPanel.setPreferredSize(new Dimension(300, 150));
    stringPanel.setBackground(Color.white);
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 0;
    gridConstraints.insets = new Insets(10, 10, 10, 10);
    getContentPane().add(stringPanel, gridConstraints);

    pack();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());

    stringPanel.repaint();

  }

  private void exitForm(WindowEvent e)
  {
    System.exit(0);
  }

}

class GraphicsPanel extends JPanel
{

  public GraphicsPanel()
  {
  }

  public void paintComponent(Graphics g)
  {
    Graphics2D g2D = (Graphics2D) g;
    super.paintComponent(g2D);

    String myString = "Hello Java!";
    Font myFont = new Font("Arial", Font.BOLD, 48);
    g2D.setFont(myFont);
    Rectangle2D stringRect = myFont.getStringBounds(myString, g2D.getFontRenderContext());
    // solid paint (may be commented out)
    g2D.setPaint(Color.RED);
    // gradient paint (may be commented out)
    GradientPaint gPaint = new GradientPaint(new Point2D.Double(0, 0), Color.BLUE, new Point2D.Double(2, 2), Color.CYAN, true);
    g2D.setPaint(gPaint);
    // textured paint (may be commented out)
    Image myImage = new ImageIcon("denim.gif").getImage();
    BufferedImage tImage = new BufferedImage(myImage.getWidth(this), myImage.getHeight(this), BufferedImage.TYPE_INT_RGB);
    Graphics2D g2DtImage = (Graphics2D) tImage.getGraphics();
    g2DtImage.drawImage(myImage, 0, 0, this);
    Rectangle2D.Double tRect = new Rectangle2D.Double(0, 0, 40, 40);
    TexturePaint tPaint = new TexturePaint(tImage, tRect);
    g2D.setPaint(tPaint);
    // next line left justfies - may be commented out
    //g2D.drawString(myString, 10, 40);
    // next line centers horizontally and vertically - may be commented out
    g2D.drawString(myString, (int) (0.5 * (DrawStringDemo.stringPanel.getWidth() - stringRect.getWidth())), (int) (0.5 * (DrawStringDemo.stringPanel.getHeight() + stringRect.getHeight())));
    // next line right justifies - may be commented out
    //g2D.drawString(myString, (int) (DrawingStrings.stringPanel.getWidth() - stringRect.getWidth()), (int) stringRect.getHeight());

    g2D.dispose();
  }
}
