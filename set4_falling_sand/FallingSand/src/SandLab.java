import java.awt.*;
import java.util.*;

public class SandLab
{
    public static void main(String[] args)
    {
        SandLab lab = new SandLab(120, 80);
        lab.run();
    }

    //add constants for particle types here
    public static final int EMPTY = 0;
    public static final int METAL = 1;
    public static final int SAND = 2;
    public static final int WATER = 3;
    public static final int AVATAR = 4;
    public static final int DIDDY_OIL = 5;
    public static final int WHITEWASHED = 7;
    public static final int SOIL = 6;
    public static final int GRASS = 8;

    //do not add any more fields
    private final int[][] grid;
    private final SandDisplay display;

    public SandLab(int numRows, int numCols)
    {
        String[] names;
        names = new String[7];
        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
        names[SAND] = "Sand";
        names[WATER] = "Water";
        names[AVATAR] = "Avatar";
        names[DIDDY_OIL] = "Diddy Oil";
        names[SOIL] = "Soil";
        display = new SandDisplay("Cypress Ranch Lab: Falling Sand", numRows, numCols, names);
        grid = new int[numRows][numCols];
    }

    //called when the user clicks on a location using the given jtool
    private void locationClicked(int row, int col, int tool)
    {
        grid[row][col] = tool;
    }

    //copies each element of grid into the display
    public void updateDisplay()
    {
        for (int i = 0; i < grid.length; i++){
            for (int j  =0; j < grid[0].length; j++){
                if (grid[i][j] == METAL) display.setColor(i, j, Color.LIGHT_GRAY);
                if (grid[i][j] == SAND) display.setColor(i, j, Color.yellow);
                if (grid[i][j] == EMPTY) display.setColor(i, j, Color.BLACK);
                if (grid[i][j] == WATER) display.setColor(i, j, Color.blue);
                if (grid[i][j] == AVATAR) display.setColor(i, j, new Color(249, 239, 227));
                if (grid[i][j] == DIDDY_OIL) display.setColor(i, j, new Color(244, 250, 252));
                if (grid[i][j] == WHITEWASHED) display.setColor(i, j, Color.white);
                if (grid[i][j] == SOIL) display.setColor(i, j, new Color(146, 104, 41));
                if (grid[i][j] == GRASS) display.setColor(i, j, new Color(124, 252, 0));
            }
        }
    }

    //called repeatedly.
    //causes one random particle to maybe do something.
    public void step()
    {
        Random r = new Random();
        int randomLocRow = r.nextInt(grid.length-1);
        int randomLocCol = r.nextInt(grid[0].length-1);
        if(grid[randomLocRow][randomLocCol] ==  SAND){
            sand(randomLocRow, randomLocCol);
        }
        else if (grid[randomLocRow][randomLocCol] == WATER){
            water(randomLocRow, randomLocCol, r);
        }
        else if (grid[randomLocRow][randomLocCol] == AVATAR){
            avatar(randomLocRow, randomLocCol);
        } else if (grid[randomLocRow][randomLocCol] == DIDDY_OIL) {
            diddy_reaction(randomLocRow, randomLocCol);
        } else if (grid[randomLocRow][randomLocCol] == SOIL){
            soil(randomLocRow, randomLocCol);
        }
    }

    public boolean isValid(int r, int c){
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length);
    }

    public void avatar(int randomLocRow, int randomLocCol){
        int[] indexes = new int[]{-1, 0, 1};
        for (int i : indexes){
            for (int j : indexes){
                if (isValid(randomLocRow+i, randomLocCol+j) && i !=0 && j !=0){
                    grid[randomLocRow+i][randomLocCol+j] = EMPTY;
                }
            }
        }
    }

    public void sand(int randomLocRow, int randomLocCol){
        if (isValid(randomLocRow+1, randomLocCol)&&grid[randomLocRow+1][randomLocCol] == EMPTY){
            grid[randomLocRow][randomLocCol] = EMPTY;
            grid[randomLocRow+1][randomLocCol] = SAND;
        }
        else if(isValid(randomLocRow+1, randomLocCol)&&grid[randomLocRow+1][randomLocCol] == WATER) {
            grid[randomLocRow][randomLocCol] = WATER;
            grid[randomLocRow+1][randomLocCol] = SAND;
        }
    }

    public void water(int randomLocRow, int randomLocCol, Random r){
        int direction = r.nextInt(3);
        if (direction == 0 && randomLocCol-1>=0 && grid[randomLocRow][randomLocCol-1] == EMPTY){
            grid[randomLocRow][randomLocCol-1] = WATER;
            grid[randomLocRow][randomLocCol] = EMPTY;
        }
        else if (direction == 1 && randomLocRow+1 < grid.length && grid[randomLocRow+1][randomLocCol] == EMPTY){
            grid[randomLocRow+1][randomLocCol] = WATER;
            grid[randomLocRow][randomLocCol] = EMPTY;
        }
        if (direction == 2 && randomLocCol+1 < grid[0].length && grid[randomLocRow][randomLocCol+1] == EMPTY){
            grid[randomLocRow][randomLocCol+1] = WATER;
            grid[randomLocRow][randomLocCol] = EMPTY;
        }
        else{
            int[] indexes = new int[]{-1, 0, 1};
            for (int i : indexes) {
                for (int j : indexes) {
                    if (isValid(randomLocRow + i, randomLocCol + j)) {
                        if (grid[i + randomLocRow][j + randomLocCol] == SOIL) {
                            grid[i + randomLocRow][j+randomLocCol] = GRASS;
                            }
                        }
                    }
                }
            }
        }

    public void diddy_reaction(int randomLocRow, int randomLocCol){
        if (grid[randomLocRow+1][randomLocCol] == EMPTY){
            grid[randomLocRow][randomLocCol] = EMPTY;
            grid[randomLocRow+1][randomLocCol] = DIDDY_OIL;
        }
        else if (grid[randomLocRow+1][randomLocCol] == WATER){
            grid[randomLocRow][randomLocCol] = WATER;
            grid[randomLocRow+1][randomLocCol] = DIDDY_OIL;
        }
        else {
            int[] indexes = new int[]{-1, 0, 1};
            for (int i : indexes) {
                for (int j : indexes) {
                    if (isValid(randomLocRow + i, randomLocCol + j)) {
                        if (grid[i + randomLocRow][j + randomLocCol] == AVATAR) {
                            for (int k = 0; k < grid.length; k++) {
                                for (int l = 0; l < grid[0].length; l++) {
                                    grid[k][l] = WHITEWASHED;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void soil(int randomLocRow, int randomLocCol){
        if (grid[randomLocRow+1][randomLocCol] == EMPTY){
            grid[randomLocRow][randomLocCol] = EMPTY;
            grid[randomLocRow+1][randomLocCol] = SOIL;
        }
    }

    //do not modify
    public void run()
    {
        while (true)
        {
            for (int i = 0; i < display.getSpeed(); i++)
                step();
            updateDisplay();
            display.repaint();
            display.pause(1);  //wait for redrawing and for mouse
            int[] mouseLoc = display.getMouseLocation();
            if (mouseLoc != null)  //test if mouse clicked
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
        }
    }
}
