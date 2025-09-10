import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class SubImageDemo extends JFrame {

	private BufferedImage image = null;
	private final String FILENAME = "trump.png";
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JButton[][] grid = new JButton[2][2];
	JButton clickedButton = new JButton("Click");

    public SubImageDemo() {
    	try{
			image = ImageIO.read(new File(FILENAME));
			initGUI();
			setTitle("SubImage Demo");
			setResizable(false);
			pack();
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        	setBounds((int) (0.5 * (screenSize.width - getWidth())),
        		(int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
    	}
    	catch(IOException e){
    		String message = "The image file " + FILENAME + " could not be opened";
			JOptionPane.showMessageDialog(this, message);
    	}
    }

	private void initGUI(){
		leftPanel.setPreferredSize(new Dimension(300,200));
		leftPanel.setLayout(new GridLayout(2,2));
		getContentPane().add(leftPanel,BorderLayout.WEST);
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				grid[i][j] = new JButton();
				BufferedImage subimage = image.getSubimage(j*150,i*100, 150, 100);
				ImageIcon imageIcon = new ImageIcon(subimage);
				grid[i][j].setIcon(imageIcon);
				leftPanel.add(grid[i][j]);
			}
		}
		rightPanel.setPreferredSize(new Dimension(300,200));
		rightPanel.setLayout(new GridLayout(2,2));
		getContentPane().add(rightPanel,BorderLayout.EAST);
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				grid[i][j] = new JButton();
				BufferedImage subimage = image.getSubimage(i*150,j*100, 150, 100);
				ImageIcon imageIcon = new ImageIcon(subimage);
				grid[i][j].setIcon(imageIcon);
				grid[i][j].setFocusPainted(false);
				grid[i][j].setBorder(null);
				rightPanel.add(grid[i][j]);

			}
		}

		clickedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clickedButtonActionPerformed(evt);
			}
		});
		getContentPane().add(clickedButton,BorderLayout.SOUTH);

	}
	private void clickedButtonActionPerformed(ActionEvent e){
		// do a random swap
		int one_x = (int)(Math.random()*2), one_y = (int)(Math.random()*2),two_x,two_y;
		do{
			two_x = (int)(Math.random()*2);
			two_y = (int)(Math.random()*2);
		}while(one_x==two_x&&one_y==two_y);

		ImageIcon otherImage = (ImageIcon)grid[one_x][one_y].getIcon();
		grid[one_x][one_y].setIcon((ImageIcon)grid[two_x][two_y].getIcon());
		grid[two_x][two_y].setIcon(otherImage);

	}
    public static void main(String[] args) {
        new SubImageDemo();
    }
}
