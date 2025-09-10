import java.awt.*;

public class Human extends Critter{

    private Color ethnicity;
    private int moves;

    public Human(Color ethnicity){
        this.ethnicity = ethnicity;
        moves = 0;
    }

    public Color getColor(){
        return ethnicity;
    }

    public String toString(){
        if (getColor().equals(Color.YELLOW)) return "A";
        else if (getColor().equals(Color.BLACK)) return "B";
        else if (getColor().equals(Color.WHITE)) return "W";
        else return "D";
    }

    public Action getMove(CritterInfo info){
        /*
        moves++;
        if (info.getFront().equals(Neighbor.OTHER)) return Action.INFECT;
        if (ethnicity == Color.BLACK){
            return Action.HOP;
        } else if (ethnicity == Color.WHITE){
            return Action.LEFT;
        } else if (ethnicity == Color.YELLOW){
            return Action.RIGHT;
        }
        return Action.INFECT;
         */
        if(moves++<500){
            if(info.getFront().equals(Neighbor.OTHER)) return Action.INFECT;
            if(info.getRight().equals(Neighbor.EMPTY) || info.getRight().equals(Neighbor.OTHER)) return Action.RIGHT;
            if(info.getLeft().equals(Neighbor.EMPTY) || info.getLeft().equals(Neighbor.OTHER)) return Action.LEFT;
            if(info.getBack().equals(Neighbor.EMPTY) || info.getBack().equals(Neighbor.OTHER)) return Action.RIGHT;
            if(info.getRight().equals(Neighbor.SAME) && info.getLeft().equals(Neighbor.SAME) && info.getFront().equals(Neighbor.SAME) && info.getBack().equals(Neighbor.SAME)){
                Direction d=info.getDirection();
                switch (d){
                    case EAST -> {
                        return Action.LEFT;
                    }
                    case WEST, SOUTH -> {
                        return Action.RIGHT;
                    }
                }
            }
        }
        else{
            if(info.getFront().equals(Neighbor.OTHER)) return Action.INFECT;
            else if(info.getFront().equals(Neighbor.EMPTY)) return Action.HOP;
            if(info.getRight().equals(Neighbor.EMPTY) || info.getRight().equals(Neighbor.OTHER)) return Action.RIGHT;
            if(info.getLeft().equals(Neighbor.EMPTY) || info.getLeft().equals(Neighbor.OTHER)) return Action.LEFT;
            if(info.getBack().equals(Neighbor.EMPTY) || info.getBack().equals(Neighbor.OTHER)) return Action.RIGHT;
        }
        return Action.INFECT;
    }

}
