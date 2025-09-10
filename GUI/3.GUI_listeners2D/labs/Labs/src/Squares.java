import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class Squares extends JFrame {




	@Serial
	private static final long serialVersionUID = 1L;
	private static final int GRIDSIZE = 3;
	private LightButton[][] lightButton = new LightButton[GRIDSIZE][GRIDSIZE];




	public Squares() {
		initGUI();
		setTitle("Squares");
		setResizable(false);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newGame();
	}




	private void initGUI() {
		TitleLabel f = new TitleLabel("Squares");
		add(f, BorderLayout.PAGE_START);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER);




		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < GRIDSIZE; j++) {
				lightButton[i][j] = new LightButton(i, j);
				centerPanel.add(lightButton[i][j]);




				int row = i, col = j;
				lightButton[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						toggleLights(row, col);
						isGameOver();
					}
				});
			}
		}
	}




	public void isGameOver() {
		boolean done = true;




		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < GRIDSIZE; j++) {
				if ((i == 1 && j == 1 && lightButton[i][j].isLit()) ||
						(i != 1 || j != 1) && !lightButton[i][j].isLit()) {
					done = false;
					break;
				}
			}
			if (!done) break;
		}




		if (done) {
			String message = "Congratulations, you completed the frame! Would you like to play again?";
			int option = JOptionPane.showConfirmDialog(this, message, "Play Again?", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				newGame();
			} else {
				System.exit(0);
			}
		}
	}




	public void toggleLights(int row, int col) {
		if (row < 0 || col < 0 || row >= GRIDSIZE || col >= GRIDSIZE) return;




		lightButton[row][col].toggle();




		if (row == 0 && col == 0) {
			toggle(row + 1, col);
			toggle(row, col + 1);
		} else if (row == 0 && col == 2) {
			toggle(row + 1, col);
			toggle(row, col - 1);
		} else if (row == 2 && col == 0) {
			toggle(row - 1, col);
			toggle(row, col + 1);
		} else if (row == 2 && col == 2) {
			toggle(row - 1, col);
			toggle(row, col - 1);
		} else if (row == 1 && col == 1) {
			toggle(row - 1, col);
			toggle(row + 1, col);
			toggle(row, col - 1);
			toggle(row, col + 1);
		} else if (row == 0 || row == 2) {
			toggle(row, col - 1);
			toggle(row, col + 1);
		} else if (col == 0 || col == 2) {
			toggle(row - 1, col);
			toggle(row + 1, col);
		}
	}




	private void toggle(int row, int col) {
		if (row >= 0 && col >= 0 && row < GRIDSIZE && col < GRIDSIZE) {
			lightButton[row][col].toggle();
		}
	}




	public void newGame() {
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < GRIDSIZE; j++) {
				lightButton[i][j].turnOff();
			}
		}
	}




	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new Squares());
	}
}


