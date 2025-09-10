import java.awt.*;

public class Giant extends Critter{
    private int moves;
    private String move;

    public Giant(){
        moves = 6;
        move = "fee";
    }

    public Color getColor(){
        return Color.GRAY;
    }

    public String toString(){
        return move;
    }

    public Action getMove(CritterInfo info){
        moves++;
        if (moves % 6 == 0) {
            if (moves / 6 % 4 == 1) move = "fee";
            else if (moves / 6 % 4 == 2) move = "fie";
            else if (moves / 6 % 4 == 3) move = "foe";
            else move = "fum";
        }

        if (info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }
}

