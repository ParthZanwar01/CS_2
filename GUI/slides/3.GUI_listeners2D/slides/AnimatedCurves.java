/*
 * AnimatedCurves.java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;

public class AnimatedCurves extends JFrame
{

  GraphicsPanel drawPanel = new GraphicsPanel();
  JButton drawButton = new JButton();
  JButton fillButton = new JButton();
  javax.swing.Timer myTimer;

  static boolean shapeDrawn = true; //set to true for proper initialization
  static boolean shapeFilled = false;
  static Color fillColor;
  static Vector myPoints = new Vector(50, 10);
  Random myRandom = new Random();

  public static void main(String args[])
  {
    //construct frame
    new AnimatedCurves().show();
  }

  public AnimatedCurves()
  {
    // code to build the form
    setTitle("Animated Curves");
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
    drawPanel.setPreferredSize(new Dimension(350, 250));
    drawPanel.setBackground(Color.WHITE);
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 0;
    gridConstraints.insets = new Insets(10, 10, 10, 10);
    getContentPane().add(drawPanel, gridConstraints);
    drawPanel.addMouseListener(new MouseAdapter()
    {
      public void mousePressed(MouseEvent e)
      {
        drawPanelMousePressed(e);
      }
    });

    drawButton.setText("Draw Curve");
    drawButton.setEnabled(false);
    gridConstraints = new GridBagConstraints();
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 1;
    getContentPane().add(drawButton, gridConstraints);
    drawButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        drawButtonActionPerformed(e);
      }
    });

    fillButton.setText("Fill Curve");
    fillButton.setEnabled(false);
    gridConstraints = new GridBagConstraints();
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 2;
    gridConstraints.insets = new Insets(5, 0, 5, 0);
    getContentPane().add(fillButton, gridConstraints);
    fillButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        fillButtonActionPerformed(e);
      }
    });

    myTimer = new javax.swing.Timer(100, new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        myTimerActionPerformed(e);
      }
    });

    pack();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
  }

  private void drawPanelMousePressed(MouseEvent e)
  {
    if (shapeDrawn)
    {
      // starting over with new drawing
      myTimer.stop();
      drawButton.setEnabled(false);
      fillButton.setEnabled(false);
      shapeDrawn = false;
      shapeFilled = false;
      myPoints.removeAllElements();
    }
    // Save clicked point and mark with red dot
    Point2D.Double myPoint = new Point2D.Double(e.getX(), e.getY());
    myPoints.add(myPoint);
    if (myPoints.size() > 2)
    {
      drawButton.setEnabled(true);
    }
    drawPanel.repaint();
  }

  private void drawButtonActionPerformed(ActionEvent e)
  {
    // connect lines
    drawButton.setEnabled(false);
    fillButton.setEnabled(true); // allow filling polygon
    shapeDrawn = true;
    drawPanel.repaint();
  }

  private void fillButtonActionPerformed(ActionEvent e)
  {
    // fill polygon
    myTimer.start();
    fillColor = new Color(myRandom.nextInt(256), myRandom.nextInt(256), myRandom.nextInt(256));
    shapeFilled = true;
    drawPanel.repaint();
  }

  private void myTimerActionPerformed(ActionEvent e)
  {
    // tweak all the control points a bit
    for (int i = 0; i < myPoints.size(); i++)
    {
      Point2D.Double myPoint = (Point2D.Double) myPoints.elementAt(i);
      myPoint.x += myRandom.nextDouble() * 20.0 - 10.0;
      myPoint.y += myRandom.nextDouble() * 20.0 - 10.0;
      myPoints.setElementAt(myPoint, i);
    }
    drawPanel.repaint();
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
    // create graphics object and connect points in x, y arrays
    GeneralPath myCurve = new GeneralPath();
    Graphics2D g2D = (Graphics2D) g;
    super.paintComponent(g2D);
    int numberPoints = AnimatedCurves.myPoints.size();
    if (numberPoints == 0)
    {
      return;
    }
    // array for control points
    Point2D[] controlPoint = new Point2D[numberPoints];
    for (int i = 0; i < numberPoints; i++)
    {
      controlPoint[i] = (Point2D.Double) AnimatedCurves.myPoints.elementAt(i);
      if (!AnimatedCurves.shapeDrawn)
      {
        // points only
        g2D.setPaint(Color.RED);
        g2D.fill(new Ellipse2D.Double(controlPoint[i].getX() - 1, controlPoint[i].getY() - 1, 3, 3));
      }
    }
    if (AnimatedCurves.shapeDrawn)
    {
      // array for curve points
      Point2D[] curvePoint = new Point2D[numberPoints];
      // establish last point first
      curvePoint[numberPoints - 1] = new Point2D.Double(0.5 * (controlPoint[numberPoints - 1].getX() + controlPoint[0].getX()), 0.5 * (controlPoint[numberPoints - 1].getY() + controlPoint[0].getY()));
      myCurve.moveTo((float) curvePoint[numberPoints - 1].getX(), (float) curvePoint[numberPoints - 1].getY());
      for (int i = 0; i < numberPoints; i++)
      {
        if (i < numberPoints - 1)
        {
          curvePoint[i] = new Point2D.Double(0.5 * (controlPoint[i].getX() + controlPoint[i + 1].getX()), 0.5 * (controlPoint[i].getY() + controlPoint[i + 1].getY()));
        }
        myCurve.quadTo((float) controlPoint[i].getX(), (float) controlPoint[i].getY(), (float) curvePoint[i].getX(), (float) curvePoint[i].getY());
      }

      if (AnimatedCurves.shapeFilled)
      {
        g2D.setPaint(AnimatedCurves.fillColor);
        g2D.fill(myCurve);
      }
      g2D.setStroke(new BasicStroke(2));
      g2D.setPaint(Color.BLUE);
      g2D.draw(myCurve);
    }
    g2D.dispose();
  }
}
