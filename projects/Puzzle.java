import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

// Author - Parth Zanwar
// Class - Computer Science 2 K
// Project - Sliding tiles
// Description - This is a fun game where you slide around the tiles in order to complete the image
public class Puzzle extends JFrame {

    private int size = 3; // Default size
    private int whiteI; // the white square row number
    private int whiteJ; // the white square column number

    private BufferedImage image = null; // the current image
    private String filename = "Sreeshan.jpg"; // the name of the image file
    private JPanel sliderPanel; // the panel in which the tiles are held
    private JPanel topPanel; // The top Panel which holds the options to change the size and the image
    private JButton[][] userGrid; // The grid of buttons displayed to the user
    private int[][] referenceOrder; // Order of which original image was generated in
    private int[][] userOrder; // Order of the current grid
    private JComboBox<String> sizeSelector; // Combo Box to select a size
    private JComboBox<String> imageSelector; // Combo Box to Select an image

    // Constructor to set up the game frame
    public Puzzle() {
        try {
            image = ImageIO.read(new File(filename));
            initGUI();
            setTitle("Slider Game");
            setVisible(true);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            pack();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "The image file " + filename + " could not be opened");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Puzzle::new);
    }

    // Method that calls other methods to set up the game
    private void initGUI() throws IOException {
        // Set up layout
        getContentPane().setLayout(new BorderLayout());
        image = ImageIO.read(new File(filename));

        // Create the top panel
        createTopPanel();
        getContentPane().add(topPanel, BorderLayout.NORTH);


        // Initialize the slider panel
        sliderPanel = new JPanel();
        createSliderPanels();
        getContentPane().add(sliderPanel, BorderLayout.CENTER);


    }

    // Method to create slider Panels
    private void createSliderPanels() throws IOException {
        // Clear the previous panel
        sliderPanel.removeAll();

        // Set up grid layout for the new size
        sliderPanel.setLayout(new GridLayout(size, size));

        // Calculate the tile size based on the smaller dimension of the image
        int sideSize = Math.min(image.getWidth(), image.getHeight());
        int tileSize = sideSize / size;

        // Initializes grids with respective objects
        userGrid = new JButton[size][size];
        referenceOrder = new int[size][size];
        userOrder = new int[size][size];

        // counter increments in each iteration to help determine the proper placement for the win condition
        int counter = 0;

        // Populate the grid with buttons and images
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                BufferedImage subImage;
                if (i == size - 1 && j == size - 1) {
                    // Create a blank sub-image for the white space
                    subImage = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
                    whiteI = i;
                    whiteJ = j;
                } else {
                    // Extract sub-image for the current grid cell
                    subImage = image.getSubimage(j * tileSize, i * tileSize, tileSize, tileSize);
                }

                // Puts the respective button into the grid
                userGrid[i][j] = new JButton(new ImageIcon(subImage));
                userGrid[i][j].setFocusPainted(false);
                userGrid[i][j].setBorder(null);

                // Adds an action listener to the button in the matrix
                int finalI = i;
                int finalJ = j;
                userGrid[i][j].addActionListener(ae -> {
                    try {
                        buttonClicked(finalI, finalJ);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                sliderPanel.add(userGrid[i][j]);

                // Puts the location of the variable in the integer matrices
                referenceOrder[i][j] = counter;
                userOrder[i][j] = counter++;
            }
        }

        // Calls other methods to set up the game
        randomizeSlides();
        revalidate();
        repaint();
    }

    // Action listener for each button in the matrix
    private void buttonClicked(int row, int col) throws IOException {
        // Check if the clicked button is adjacent to the white space
        if ((Math.abs(row - whiteI) == 1 && col == whiteJ) || (Math.abs(col - whiteJ) == 1 && row == whiteI)) {
            swap(row, col, whiteI, whiteJ, true); // swaps tiles if true
        }
    }

    private boolean inBounds(int row, int column) {
        return row >= 0 && row < size && column >= 0 && column < size;
    }

    // Swap method to swap tiles to new location
    private void swap(int fromRow, int fromCol, int toRow, int toCol, boolean checkWin) throws IOException {
        // Swap icons between the buttons
        Icon temp = userGrid[fromRow][fromCol].getIcon();
        userGrid[fromRow][fromCol].setIcon(userGrid[toRow][toCol].getIcon());
        userGrid[toRow][toCol].setIcon(temp);

        //Swap the numbers
        int holder = userOrder[fromRow][fromCol];
        userOrder[fromRow][fromCol] = userOrder[toRow][toCol];
        userOrder[toRow][toCol] = holder;

        // Update the white space position
        whiteI = fromRow;
        whiteJ = fromCol;

        // Checks if method should check win
        if (checkWin) {
            if (win()) { // checks if win condition is met
                // Slots in missing piece
                userGrid[size - 1][size - 1].setIcon((new ImageIcon((image.getSubimage((size - 1) * Math.min(image.getHeight(), image.getWidth()) / size, (size - 1) * Math.min(image.getHeight(), image.getWidth()) / size, Math.min(image.getHeight(), image.getWidth()) / size, Math.min(image.getHeight(), image.getWidth()) / size)))));
                // Repaints the slides
                repaint();
                // Displays message on the screen
                JOptionPane.showMessageDialog(null, "YOU WIN!");
                int response = JOptionPane.showConfirmDialog(null, "Play Again?", "Play Again?", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    createSliderPanels();
                } else if (response == JOptionPane.NO_OPTION) {
                    dispose();
                }
            }
        }
    }



    private void randomizeSlides() throws IOException {
        // Number of random moves to make
        int randomMoves = size * size * 10; // Arbitrarily chosen; adjust as needed

        for (int i = 0; i < randomMoves; i++) {
            // Get the valid neighbors of the white tile
            ArrayList<int[]> neighbors = getAdjacentTiles(whiteI, whiteJ);

            // Randomly pick one of the neighbors
            int[] randomNeighbor = neighbors.get((int) (Math.random() * neighbors.size()));

            // Swap the white tile with the selected neighbor
            swap(randomNeighbor[0], randomNeighbor[1], whiteI, whiteJ, false);

            // Update the white tile's position
            whiteI = randomNeighbor[0];
            whiteJ = randomNeighbor[1];
        }

    }

    // Method to get valid adjacent tiles of a given tile
    private ArrayList<int[]> getAdjacentTiles(int row, int col) {
        ArrayList<int[]> neighbors = new ArrayList<>();

        // Check each possible direction: up, down, left, right
        if (row > 0) neighbors.add(new int[]{row - 1, col}); // Up
        if (row < size - 1) neighbors.add(new int[]{row + 1, col}); // Down
        if (col > 0) neighbors.add(new int[]{row, col - 1}); // Left
        if (col < size - 1) neighbors.add(new int[]{row, col + 1}); // Right

        return neighbors;
    }







    // Creates the top Panel of the Puzzle
    private void createTopPanel() {
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
    }

    // Scales the image if it is too big to fit in the frame
    private void scaleImage() throws IOException {
        image = ImageIO.read(new File(filename));
        int sideSize = Math.min(Math.min(image.getWidth(), image.getHeight()), 300);
        Image scaled = image.getScaledInstance(sideSize, sideSize, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(sideSize, sideSize, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(scaled, 0, 0, null);
        image = outputImage;
    }

    // Checks to see if the user has won
    private boolean win() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!(referenceOrder[i][j] == userOrder[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
