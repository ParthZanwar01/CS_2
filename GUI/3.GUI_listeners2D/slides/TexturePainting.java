/*
 * TexturePainting.java
 */
//package texturepainting;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;

public class TexturePainting extends JFrame
{

  JFileChooser paintChooser = new JFileChooser();
  JPanel paintPanel = new JPanel();

  public static void main(String args[])
  {
    //construct frame
    new TexturePainting().show();
  }

  public TexturePainting()
  {
    // create frame
    setTitle("Texture Painting");
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
    paintChooser.addChoosableFileFilter(new FileNameExtensionFilter("Graphics Files", "gif", "jpg"));
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 0;
    getContentPane().add(paintChooser, gridConstraints);
    paintChooser.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        paintChooserActionPerformed(e);
      }
    });

    paintPanel.setPreferredSize(new Dimension(270, 300));
    paintPanel.setBackground(Color.white);
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 0;
    gridConstraints.insets = new Insets(10, 10, 10, 10);
    getContentPane().add(paintPanel, gridConstraints);

    pack();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());

  }

  private void paintChooserActionPerformed(ActionEvent e)
  {
    // create paint
    if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION))
    {
      Image myImage = new ImageIcon(paintChooser.getSelectedFile().toString()).getImage();
      BufferedImage tImage = new BufferedImage(myImage.getWidth(this), myImage.getHeight(this), BufferedImage.TYPE_INT_RGB);
      Graphics2D g2DtImage = (Graphics2D) tImage.getGraphics();
      g2DtImage.drawImage(myImage, 0, 0, this);
      // use full size graphic for paint
      Rectangle2D.Double tRect = new Rectangle2D.Double(0, 0, myImage.getWidth(this), myImage.getHeight(this));
      TexturePaint tPaint = new TexturePaint(tImage, tRect);
      // paint panel
      Graphics2D g2D = (Graphics2D) paintPanel.getGraphics();
      Rectangle2D.Double myRectangle = new Rectangle2D.Double(0, 0, paintPanel.getWidth(), paintPanel.getHeight());
      g2D.setPaint(tPaint);
      g2D.fill(myRectangle);
    }
  }

  private void exitForm(WindowEvent e)
  {
    System.exit(0);
  }
}
