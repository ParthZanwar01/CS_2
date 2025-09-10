import java.awt.*;
import javax.swing.*;
public class Template extends JFrame {

    public Template() {
    	setTitle("This is a Template");
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//add(new DrawingPanel());
		pack();
		//centers the frame
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5*(screensize.width-getWidth())), (int)(.5*(screensize.height-getHeight())), getWidth(), getHeight() );
    }
    public void initGUI(){
    	// add anything else here plus other methods below
    }
    public static void main(String[] args) {
        new Template();
    }
    private class DrawingPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			// your code goes here
		}
    }
}
