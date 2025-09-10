import javax.swing.*;
import java.awt.*;
import java.util.Random;


/**
 * Author: Parth Zanwar
 * Game: Guess the Color
 * Date: 1/13/25
 * Class: CSK2
 * **/
public class GUI_GuessingColorGame extends JFrame {
    // Buttons for changing the color
    private final JButton redDecrease = new JButton("-");
    private final JButton greenDecrease = new JButton("-");
    private final JButton blueDecrease = new JButton("-");
    private final JButton redIncrease = new JButton("+");
    private final JButton blueIncrease = new JButton("+");
    private final JButton greenIncrease = new JButton("+");

    // Buttons for changing the difficulty
    private final JButton easy = new JButton("easy");
    private final JButton medium = new JButton("medium");
    private final JButton hard = new JButton("hard");
    private final JButton impossible = new JButton("Bruh just give up!");

    // Panels to add in each side of the frame
    private final JPanel South = new JPanel();
    private final JPanel North = new JPanel();
    private final JPanel Center = new JPanel();

    // Panels to combine for the title and the difficulty buttons
    private final JPanel difficultPanel = new JPanel();
    private final JPanel titlePanel = new JPanel();

    //Text for the heading
    private final JLabel title = new JLabel("Guess the Color");

    // Panels for the guessing and target color
    private final JPanel guess_panel = new JPanel();
    private final JPanel targetPanel = new JPanel();

    // Color of the guess color
    private int red =  0;
    private int green = 0;
    private int blue = 0;

    // Randomizer for th random color
    Random r = new Random();

    // Color change if different mode is selected
    private static int COLOR_CHANGE = 30;

    // Target color to guess
    Color target_color = new Color(r.nextInt(9)*30, r.nextInt(9)*30, r.nextInt(9)*30);

    // Main constructor
    GUI_GuessingColorGame(){
        // Sets the layout of the content pane to broder layout
        getContentPane().setLayout(new BorderLayout());

        // Various method that each add a different section to the pane
        Buttons();
        Title();
        CenterPanels();
        modesButtons();

        //Sets the main frame to the specific parameters
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700, 500);

    }

    public static void main(String[] args) {
        // Runs the constructor for the user when run is clicked
        GUI_GuessingColorGame demo = new GUI_GuessingColorGame();
    }

    // Method to create the color changing buttons
    public void Buttons(){
        // Sets the background of each button to the red, green, and blue colors
        redDecrease.setBackground(Color.red);
        redIncrease.setBackground(Color.red);
        greenIncrease.setBackground(Color.green);
        greenDecrease.setBackground(Color.green);
        blueIncrease.setBackground(Color.blue);
        blueDecrease.setBackground(Color.blue);

        // Sets the text color of each button to white
        redIncrease.setForeground(Color.WHITE);
        greenIncrease.setForeground(Color.WHITE);
        blueIncrease.setForeground(Color.WHITE);
        redDecrease.setForeground(Color.WHITE);
        blueDecrease.setForeground(Color.WHITE);
        greenDecrease.setForeground(Color.WHITE);


        //Adds action listener to each button for color change
        redIncrease.addActionListener(ae -> setRed(red+COLOR_CHANGE));
        redDecrease.addActionListener(ae -> setRed(red-COLOR_CHANGE));
        blueIncrease.addActionListener(ae -> setBlue(blue + COLOR_CHANGE));
        blueDecrease.addActionListener(ae -> setBlue(blue-COLOR_CHANGE));
        greenIncrease.addActionListener(ae -> setGreen(green+COLOR_CHANGE));
        greenDecrease.addActionListener(ae -> setGreen(green-COLOR_CHANGE));

        // Adds all the buttons to the South Panel
        South.setLayout(new FlowLayout());
        South.add(redIncrease, BorderLayout.SOUTH);
        South.add(redDecrease, BorderLayout.SOUTH);
        South.add(greenIncrease, BorderLayout.SOUTH);
        South.add(greenDecrease, BorderLayout.SOUTH);
        South.add(blueIncrease, BorderLayout.SOUTH);
        South.add(blueDecrease, BorderLayout.SOUTH);

        // Sets the South panels background to Black
        South.setBackground(Color.BLACK);

        // Adds the South panel to the main frame
        add(South, BorderLayout.SOUTH);
    }

    // Method to add the title of the game
    public void Title(){
        // Sets the text parameters of the label
        title.setFont(new Font("Arial", Font.BOLD, 61));

        // Sets the text color
        title.setForeground(Color.WHITE);

        // Adds title to the titlePanel
        titlePanel.add(title);

        // Changes background of the title panel to black
        titlePanel.setBackground(Color.BLACK);
    }

    // Method to create panels for the target and guess panels
    public void CenterPanels(){

        // Creates the target panel and sets it to the randomized color
        targetPanel.setBackground(target_color);
        targetPanel.setPreferredSize(new Dimension(300, 300));

        // Creates the guess panel and sets it to initial color black
        guess_panel.setBackground(new Color(red, green, blue));
        guess_panel.setPreferredSize(new Dimension(300, 300));

        // Adds both panels to the Center Panel, which has a flow layout
        Center.setLayout(new FlowLayout());
        Center.add(targetPanel);
        Center.add(guess_panel);

        // Adds the Center panel to the main frame
        add(Center, BorderLayout.CENTER);
    }

    // Method to create the buttons for the methods and add actions to them
    public void modesButtons(){

        // Sets the background of the buttons to navy
        Color navy = new Color(0, 0, 103);
        easy.setBackground(navy);
        medium.setBackground(navy);
        hard.setBackground(navy);
        impossible.setBackground(navy);

        // Sets the text of each button to white
        easy.setForeground(Color.white);
        medium.setForeground(Color.white);
        hard.setForeground(Color.white);
        impossible.setForeground(Color.white);

        // Adds an action listener to each button to change the difficulty of the game
        easy.addActionListener(ae -> setDifficulty(0));
        medium.addActionListener(ae -> setDifficulty(1));
        hard.addActionListener(ae -> setDifficulty(2));
        impossible.addActionListener(ae -> setDifficulty(3));

        // Adds each difficulty button to the difficulty panel
        difficultPanel.setLayout(new FlowLayout());
        difficultPanel.add(easy);
        difficultPanel.add(medium);
        difficultPanel.add(hard);
        difficultPanel.add(impossible);

        // Sets the North panel border layout to BoxLayout
        North.setLayout(new BoxLayout(North, BoxLayout.Y_AXIS));

        // Adds the title and difficulty panels
        North.add(titlePanel);
        North.add(difficultPanel);

        // Adds north panel to the main frame
        add(North, BorderLayout.NORTH);
    }

    // Sets the red color of guess_color
    public void setRed(int red){
        if (inBounds(red)){
            this.red = red;
            System.out.printf("Target color: r = %d, g = %d, b = %d\n", target_color.getRed(), target_color.getGreen(), target_color.getBlue());
            System.out.printf("Guess Color: r = %d, g = %d, b = %d\n\n", red, green, blue);
            CenterPanels(); // Updates the panel
            sameColor(); //  Checks if target color matches guess color
        }
    }

    // Sets the green color of guess_color
    public void setGreen(int green){
        if (inBounds(green)){
            this.green = green;
            System.out.printf("Target color: r = %d, g = %d, b = %d\n", target_color.getRed(), target_color.getGreen(), target_color.getBlue());
            System.out.printf("Guess Color: r = %d, g = %d, b = %d\n\n", red, green, blue);
            CenterPanels(); // Updates the panel
            sameColor(); //  Checks if target color matches guess color
        }

    }

    // Sets the blue color of guess_color
    public void setBlue(int blue){
        if (inBounds(blue)){
            this.blue = blue;
            System.out.printf("Target color: r = %d, g = %d, b = %d\n", target_color.getRed(), target_color.getGreen(), target_color.getBlue());
            System.out.printf("Guess Color: r = %d, g = %d, b = %d\n\n", red, green, blue);
            CenterPanels(); // Updates the panel
            sameColor(); //  Checks if target color matches guess color
        }
    }

    // Checks if the colors are within the boundaries of the rgb values
    public boolean inBounds(int value){
        return value >= 0 && value <= 255/COLOR_CHANGE*COLOR_CHANGE;
    }

    // Method to check if the target and guess colors match
    public void sameColor(){
        if (red == target_color.getRed() && green == target_color.getGreen() && blue == target_color.getBlue()){
            // Congrats user on beating the game
            JOptionPane.showMessageDialog(null, String.format("Congratulations, you guessed the color.\n It was r: %d, g: %d, b: %d", red, green, blue));
            // Asks the user if they want to play again, if yes new screen starts, else if no game closes
            int response = JOptionPane.showConfirmDialog(null, "Do you want to play again? ", "Play Again", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION){
                dispose();
                new GUI_GuessingColorGame();
            } else {
                dispose();
            }
        }
    }

    // Sets the difficulty of the game
    public void setDifficulty(int value){
        // Easy mode - colors increase and decrease by 60
        if (value == 0){
            COLOR_CHANGE = 60;
            red = 0;
            green = 0;
            blue = 0;
            target_color = new Color(r.nextInt(5)*60, r.nextInt(5)*60, r.nextInt(5)*60);
            CenterPanels();
        }
        // Medium mode - colors increase and decrease by 30, this is the default mode
        if (value == 1){
            COLOR_CHANGE = 30;
            red = 0;
            green = 0;
            blue = 0;
            target_color = new Color(r.nextInt(9)*30, r.nextInt(9)*30, r.nextInt(9)*30);
            CenterPanels();
        }
        // Hard mode - colors increase and decrease by 15
        if (value == 2){
            COLOR_CHANGE = 15;
            red = 0;
            blue = 0;
            green = 0;
            target_color = new Color(r.nextInt(255/15 + 1)*15, r.nextInt(255/15 + 1)*15, r.nextInt(255/15 + 1)*15);
            CenterPanels();
        }
        // Impossible mode - colors increase and decrease by 1
        if (value == 3) {
            COLOR_CHANGE = 1;
            red = 0;
            blue = 0;
            green = 0;
            target_color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
            CenterPanels();
        }
    }
}
