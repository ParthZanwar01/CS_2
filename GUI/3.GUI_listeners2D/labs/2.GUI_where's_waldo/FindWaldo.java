import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FindWaldo extends JFrame {

    JLabel leftLabel = new JLabel();
    JLabel centerLabel = new JLabel();
    JLabel rightLabel = new JLabel();
    JButton playAgainButton = new JButton();
    ImageIcon waldoIcon = new ImageIcon("WALDO.png");
    private int rnd = 0; // modify to randomly choose between 0, 1 and 2


    public static void main(String[] args) {

    }
    public FindWaldo(){
		// use your best judgement on which layout manager to use







        // add center panel to frame









        // add play again button to bottom of frame





        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());

    }
    private void playAgainButtonActionPerformed(ActionEvent e){





    }

    private void leftLabelMouseClicked(MouseEvent e){




    }
    private void centerLabelMouseClicked(MouseEvent e){




    }
    private void rightLabelMouseClicked(MouseEvent e){




    }
}
