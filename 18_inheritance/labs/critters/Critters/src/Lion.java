import java.awt.*;
import java.util.Random;

public class Lion extends Critter{

    private int moves;

    private Color[] colors = new Color[]{Color.RED, Color.BLUE, Color.GREEN};
    private Color currentColor;

    public Lion(){
        moves = 0;
    }

    @Override
    public Color getColor() {
        if (moves%3==0) currentColor = colors[new Random().nextInt(3)];
        return currentColor;
    }

    public String toString(){
        return "L";
    }

    public Action getMove(CritterInfo info){
        moves++;
        if (info.getFront() == Neighbor.OTHER) return Action.INFECT;
        if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) return Action.LEFT;
        if (info.getFront() == Neighbor.SAME) return Action.RIGHT;
        else return Action.HOP;
    }
}

