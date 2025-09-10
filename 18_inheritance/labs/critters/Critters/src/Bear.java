import java.awt.*;

public class Bear extends Critter{

    private boolean polar;

    private int move = 0;

    public Bear(boolean polar){
        this.polar = polar;
    }

    public Color getColor(){
        return polar ? Color.WHITE : Color.BLACK;
    }

    public String toString(){
        return move%2==0 ? "/" : "\\";
    }

    public Action getMove(CritterInfo info){
        move++;
        if (info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }
    
}
