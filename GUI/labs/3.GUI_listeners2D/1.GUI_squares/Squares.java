import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Squares extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int GRIDSIZE =3;
	private LightButton[][] lightButton= new LightButton[GRIDSIZE][GRIDSIZE];
	public Squares(){
		initGUI();
		setTitle("Squares");
		setResizable(false);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newGame();
	}
	private void initGUI(){
		TitleLabel f = new TitleLabel("Squares");
		add(f,BorderLayout.PAGE_START);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE,GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER);
		// use a loop to add the 9 LightButtons with listeners
		// be sure to check if the game is over inside the listeners









	}
	public void isGameOver(){
		// check to see if the game is over






		if(done){
			String message = "Congratulations you won! Would you like to play again?";
			int option = JOptionPane.showConfirmDialog(this, message, "Play Again?", JOptionPane.YES_NO_OPTION);
			if(option==JOptionPane.YES_OPTION){
				newGame();
			}
			else
				System.exit(0);

		}

	}
	public void toggleLights(int row, int col){
		// add code to change the lights as outlined





	}
	public void newGame(){
		/*for(int i=0; i<GRIDSIZE; i++)				//sets all to red but center black
			for(int j=0; j<GRIDSIZE; j++)
				lightButton[i][j].turnOn();
		lightButton[1][1].toggle();*/

		int times = (int)(Math.random()*50)+10;  //randomizes the colors in a winning manner
		for(int i=0; i<times; i++){
			int r = (int)(Math.random()*3);
			int c = (int)(Math.random()*3);
			//lightButton[r][c].toggle();
			toggleLights(r,c);
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Squares();

			}
		});
	}

}
