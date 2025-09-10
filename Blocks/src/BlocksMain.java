import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class BlocksMain extends JPanel implements MouseListener, KeyListener, ActionListener {
    private static BlockManager blockManager;
    private final Timer timer;
    Random rand = new Random();


    public BlocksMain() {
        setBackground(Color.WHITE);
        setFocusable(true);
        addMouseListener(this);
        addKeyListener(this);

        // Initialize blockManager if it's null
        if (blockManager == null) {
            blockManager = new BlockManager();
        }

        timer = new Timer(10, this); // Runs every ten milliseconds
        timer.start();
        int x,y,wid,height;
        for (int i = 0; i < 20; i++) {
            x = rand.nextInt(630);
            y = rand.nextInt(410);
            wid = rand.nextInt(50,150);
            height = rand.nextInt(50,150);
            blockManager.addBlock(new Block(x, y, wid, height, randomColor()));
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        blockManager.drawAll(g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        blockManager.moveAll(getWidth(), getHeight());
        repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        requestFocusInWindow(); // Ensure key events are received
        int x = e.getX(), y = e.getY();
        if (SwingUtilities.isLeftMouseButton(e)) {
            if((e.getModifiersEx() & InputEvent.SHIFT_DOWN_MASK)!= 0 ){
                blockManager.lower(x, y);
            }
            else {
                blockManager.raise(x, y);


            }
        } else if (SwingUtilities.isRightMouseButton(e)) {
            if((e.getModifiersEx() & InputEvent.SHIFT_DOWN_MASK)!= 0 ){
                blockManager.deleteAll(x, y);
            }
            else {
                blockManager.delete(x, y);
            }
        } else if (SwingUtilities.isMiddleMouseButton(e)) {
            blockManager.explode(x,y);
        }
        repaint();
    }


    // Unused mouse events
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}


    @Override
    public void keyPressed(KeyEvent e) {
        Point p = getMousePosition();
        if (p == null) return;
        int xR,yR,wid,height;
        char key = e.getKeyChar();


        switch (key) {
            case 'n':
                xR = rand.nextInt(0,getWidth()-150);
                yR = rand.nextInt(0,getHeight()-150);
                wid = rand.nextInt(50,150);
                height = rand.nextInt(50,150);
                blockManager.addBlock(new Block(xR, yR, wid, height, randomColor()));
                break;
            case 's':
                blockManager.shuffle(getWidth(), getHeight());
                break;
            case 'e':
                blockManager.explodeAll();
                break;
            case 'i':
                blockManager.implodeAll();
                break;
            case 'c':
                blockManager.clear();
                break;
        }
        repaint();
    }


    // Unused key events
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}




    // Main - sets up the
    public static void main(String[] args) {
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton reset = new JButton("Reset");
        JButton step = new JButton("Step");
        start.setBackground(Color.GREEN);
        stop.setBackground(Color.red);
        reset.setBackground(Color.BLACK);
        step.setBackground(Color.GRAY);

        // Initialize blockManager before creating the panel
        blockManager = new BlockManager();

        JFrame frame = new JFrame("Blocks Assignment");
        frame.setLayout(new BorderLayout());
        BlocksMain panel = new BlocksMain();
        frame.add(panel,BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(start);
        buttonPanel.add(stop);
        buttonPanel.add(reset);
        buttonPanel.add(step);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        start.addActionListener(e -> panel.timer.start());
        stop.addActionListener(e-> panel.timer.stop());
        reset.addActionListener(e-> {
            blockManager.clear();
            panel.repaint();
        });
        step.addActionListener(e-> {
            blockManager.moveAll(panel.getWidth(), panel.getHeight());
            panel.repaint();
        });




        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);


    }


    public static Color randomColor() {
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r, g, b);
    }
}


class BlockManager {
    private final java.util.List<Block> blocks;
    private final Random random;


    public BlockManager() {
        blocks = new ArrayList<>();
        random = new Random();
    }


    public void addBlock(Block block) {
        blocks.add(block);
    }




    public void drawAll(Graphics g) {
        for (Block block : blocks) {
            block.draw(g);
        }
    }


    public void raise(int x, int y) {
        Block toRaise = null;
        int indexToRemove = -1;


        for (int i = blocks.size() - 1; i >= 0; i--) {
            Block block = blocks.get(i);
            if (block.contains(x, y)) {
                toRaise = block;
                indexToRemove = i;
                break;
            }
        }


        if (toRaise != null) {
            blocks.remove(indexToRemove);
            blocks.add(toRaise);
        }
    }


    public void lower(int x, int y) {
        Block toLower = null;
        int indexToRemove = -1;


        for (int i = blocks.size() - 1; i >= 0; i--) {
            Block block = blocks.get(i);
            if (block.contains(x, y)) {
                toLower = block;
                indexToRemove = i;
                break;
            }
        }


        if (toLower != null) {
            blocks.remove(indexToRemove);
            blocks.add(0, toLower);
        }
    }


    public void delete(int x, int y) {
        for (int i = blocks.size() - 1; i >= 0; i--) {
            Block block = blocks.get(i);
            if (block.contains(x, y)) {
                blocks.remove(i);
                break;
            }
        }
    }


    public void deleteAll(int x, int y) {
        for (int i = blocks.size() - 1; i >= 0; i--) {
            Block block = blocks.get(i);
            if (block.contains(x, y)) {
                blocks.remove(i);
            }
        }
    }


    public void shuffle(int width, int height) {
        Collections.shuffle(blocks);


        for (Block block : blocks) {
            int newX = random.nextInt(width - block.getWidth());
            int newY = random.nextInt(height - block.getHeight());
            block.setX(newX);
            block.setY(newY);


            int[] speeds = {-2, -1, 1, 2};
            block.setDx(speeds[random.nextInt(speeds.length)]);
            block.setDy(speeds[random.nextInt(speeds.length)]);
        }
    }


    public void moveAll(int width, int height) {
        for (int i = blocks.size() - 1; i >= 0; i--) {
            Block block = blocks.get(i);
            block.move();


            if (block instanceof ExplodingBlock) {
                if (((ExplodingBlock) block).isOutOfBounds(width, height)) {
                    blocks.remove(i);
                }
            } else {
                block.handleBoundaryCollision(width, height);
            }
        }
    }


    public void explode(int x, int y) {
        java.util.List<Block> blocksToExplode = new ArrayList<>();


        for (int i = blocks.size() - 1; i >= 0; i--) {
            Block block = blocks.get(i);
            if (block.contains(x, y) && !(block instanceof ExplodingBlock)) {
                blocksToExplode.add(block);
                blocks.remove(i);
            }
        }


        for (Block block : blocksToExplode) {
            createExplodingBlocks(block, false);
        }
    }


    public void explodeAll() {
        java.util.List<Block> blocksToExplode = new ArrayList<>();


        for (int i = blocks.size() - 1; i >= 0; i--) {
            Block block = blocks.get(i);
            if (!(block instanceof ExplodingBlock)) {
                blocksToExplode.add(block);
                blocks.remove(i);
            }
        }


        for (Block block : blocksToExplode) {
            createExplodingBlocks(block, false);
        }
    }


    public void implodeAll() {
        java.util.List<Block> blocksToImplode = new ArrayList<>();


        for (int i = blocks.size() - 1; i >= 0; i--) {
            Block block = blocks.get(i);
            if (!(block instanceof ExplodingBlock)) {
                blocksToImplode.add(block);
                blocks.remove(i);
            }
        }


        for (Block block : blocksToImplode) {
            createExplodingBlocks(block, true);
        }
    }


    private void createExplodingBlocks(Block block, boolean implode) {
        int width = block.getWidth();
        int height = block.getHeight();
        double centerX = block.getCenterX();
        double centerY = block.getCenterY();
        Color color = block.getColor();


        for (int py = 0; py < height; py++) {
            for (int px = 0; px < width; px++) {
                double x = block.getX() + px + 0.5;
                double y = block.getY() + py + 0.5;


                double angle = Math.atan2(y - centerY, x - centerX);


                if (implode) {
                    angle += Math.PI;
                }


                ExplodingBlock explodingBlock = new ExplodingBlock(x, y, color, angle);
                blocks.add(explodingBlock);
            }
        }
    }


    public void clear() {
        blocks.clear();
    }
}






class ExplodingBlock extends Block {
    private double xDouble;  // Store x as a double for precise movement
    private double yDouble;  // Store y as a double for precise movement
    private final double angle;    // Angle of movement in radians
    private static final int EXPLODING_SPEED = 3;  // Speed of exploding blocks


    /**
     * Constructor for ExplodingBlock
     * @param x initial x position
     * @param y initial y position
     * @param color color of the exploding block
     * @param angle angle of movement in radians
     */
    public ExplodingBlock(double x, double y, Color color, double angle) {
        // Call super with cast values, 1x1 size, and 0 speed (we'll handle movement differently)
        super((int)x, (int)y, 1, 1, color);
        this.xDouble = x;
        this.yDouble = y;
        this.angle = angle;
    }


    @Override
    public void move() {
        // Move based on the angle
        xDouble += EXPLODING_SPEED * Math.cos(angle);
        yDouble += EXPLODING_SPEED * Math.sin(angle);


        // Update the integer coordinates
        super.setX((int)xDouble);
        super.setY((int)yDouble);
    }


    /**
     * Checks if the exploding block is out of bounds
     * @param screenWidth width of the screen
     * @param screenHeight height of the screen
     * @return true if out of bounds, false otherwise
     */
    public boolean isOutOfBounds(int screenWidth, int screenHeight) {
        int x = getX();
        int y = getY();
        return x < 0 || y < 0 || x > screenWidth  || y > screenHeight ;
    }


    // Override getters and setters for x and y to work with double precision
    @Override
    public void setX(int x) {
        this.xDouble = x;
        super.setX(x);
    }


    @Override
    public void setY(int y) {
        this.yDouble = y;
        super.setY(y);
    }
}
/**
 * @author Parth Zanwar
 * @version 9/3/2024
 */
class Block {
    //instance variables
    private int xPos;
    private int yPos;


    private final int width;
    private final int height;


    private final Color color;


    private int dx, dy;


    //constructors


    /**
     * Constructor that creates a Block with the specified arguments
     * @param x x location of the Block
     * @param y y location of the Block
     * @param width width of the Block
     * @param height height of the Block
     * @param color Color of the Block
     */
    public Block(int x, int y, int width, int height, Color color) {
        xPos = x;
        yPos = y;
        this.width = width;
        this.height = height;
        this.color = color;
        dx = randomSpeed();
        dy = randomSpeed();
    }


    public int randomSpeed() {
        int[] speeds = {-2, -1, 1, 2};
        return speeds[(int)(Math.random() * speeds.length)];
    }


    public void setDx(int dx) {
        this.dx = dx;
    }


    public void setDy(int dy) {
        this.dy = dy;
    }




    public void setX(int x) {
        this.xPos = x;
    }


    public void setY(int y) {
        this.yPos = y;
    }


    /**
     * Draws the Block via the Graphics reference using its attributes
     * @param window - Makes a window where the Block is displayed
     */
    public void draw(Graphics window) {
        window.setColor(color);
        window.fillRect(xPos, yPos, width, height);
        window.setColor(Color.BLACK);
        window.drawRect(xPos, yPos, width, height);
    }


    //get methods
    public int getX() {
        return xPos;
    }


    public int getY() {
        return yPos;
    }


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }


    public Color getColor() {
        return color;
    }


    public void move() {
        xPos += dx;
        yPos += dy;
    }


    /**
     * Handles collision with screen boundaries
     * @param screenWidth width of the screen
     * @param screenHeight height of the screen
     */
    public void handleBoundaryCollision(int screenWidth, int screenHeight) {
        if (xPos <= 0 || xPos + width >= screenWidth) {
            dx *= -1;
            // Ensure block stays within bounds
            xPos = Math.max(0, Math.min(xPos, screenWidth - width));
        }
        if (yPos <= 0 || yPos + height >= screenHeight) {
            dy *= -1;
            // Ensure block stays within bounds
            yPos = Math.max(0, Math.min(yPos, screenHeight - height));
        }
    }


    //toString
    /**
     * Returns a String representation of this object in the format "x y width height color". Invokes the toString() from the Color class
     * @return String
     */
    @Override
    public String toString() {
        return xPos + " " + yPos + " " + width + " " + height + " " + color.toString();
    }


    /**
     * Returns true if the xPos and yPos is within the boundary inclusive of this Block and false otherwise
     * @param xPos The x coordinate of the specified point
     * @param yPos The y coordinate of the specified point
     * @return boolean
     */
    public boolean contains(int xPos, int yPos) {
        return this.xPos <= xPos && xPos <= this.xPos + width &&
                this.yPos <= yPos && yPos <= this.yPos + height;
    }


    /**
     * Calculates the center x-coordinate of the block
     * @return center x-coordinate
     */
    public double getCenterX() {
        return xPos + width / 2.0;
    }


    /**
     * Calculates the center y-coordinate of the block
     * @return center y-coordinate
     */
    public double getCenterY() {
        return yPos + height / 2.0;
    }
}