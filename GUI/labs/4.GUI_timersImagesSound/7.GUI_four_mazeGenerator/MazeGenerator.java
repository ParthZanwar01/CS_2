
//package mazegenerator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MazeGenerator extends JFrame {
    // add instance variables
    int row=0, col=0, endRow = row-1, endCol= col-1;
    Cell[][] cell = new Cell[20][20];

    public MazeGenerator() {
        initGUI();
        setTitle("MazeGenerator");
    	setVisible(true);
        setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the menu bar


        // add a timer for solving the maze

        pack();
	//centers the frame
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5*(screensize.width-getWidth())), (int)(.5*(screensize.height-getHeight())), getWidth(), getHeight() );
    }
    private void initGUI(){


        // create maze



        // add listeners



        // add button panel with buttons to reset



    }
    private void changeOptions(){
        // instantiate an object that extends JDialog and add all of the pertinent code



    }
    private void keyReleasedKeyEvent(KeyEvent e){
      /*  // check the four different key presses
        if(e.getKeyCode()==KeyEvent.VK_UP){
            // move up if this cell does not have a top wall
            if(cell[row][col].wall[Cell.TOP]==false){
                moveTo(row-1,col,Cell.TOP,Cell.BOTTOM);
                // move up more if this is a long column(loop checking top-false,left-true,right-true)
                while(cell[row][col].wall[Cell.TOP]==false&&cell[row][col].wall[Cell.LEFT]&&cell[row][col].wall[Cell.RIGHT]){
                    moveTo(row-1,col,Cell.TOP,Cell.BOTTOM);
                }
            }
        }*/
        // 3 more cases







        // check to see if the game is over
        if (row == endRow && col == endCol) {
            String message = "Congratulations! You solved it."; JOptionPane.showMessageDialog( this, message);
        }

    }
    private void moveTo(int nextRow, int nextCol, int firstDirection, int secondDirection){
        // update the current cell(change boolean curr to false) and add the path(firstD)
        // update row and col to next
        // update cell[row][col] to current and add the path(secondD)





        // and repaint since changes were made
        repaint();

    }
    private void createMaze(){
        //mazePanel.removeAll();
        // add code to create the grid and call carvePassages() below






        //mazePanel.revalidate();
        pack();
    }

    private void carvePassages(){
        // choose a random spot to start from




    }
    private boolean inBounds(int r,int c){

		return false;
    }
    private boolean isAvailable( int r, int c) {
		//must be inbounds and have all walls
		return false;
    }

    private void solve(){
        //BFS or DFS alogorithm






    }
    public static void main(String[] args) {
        new MazeGenerator();
    }
}
class Cell extends JPanel{

    public static final int TOP = 0;
    public static final int RIGHT = 1;
    public static final int BOTTOM = 2;
    public static final int LEFT = 3;
    private static final int SIZE = 20;
    //add instance variables as needed

    //constructor

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }
    public Dimension getPreferredSize() {
        Dimension size = new Dimension( SIZE, SIZE);
        return size;
    }

    public void openTo( Cell neighbor) {
	// this method opens the wall up



    }
}
class OptionsDialog extends JDialog{


}