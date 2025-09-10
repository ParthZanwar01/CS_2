import java.awt.*;
import java.util.Random;

public class Anish extends Critter{
    private int cnt;
    private Random rand=new Random();
    private Color color;
    public Anish(){
        cnt=1;
    }

    @Override
    public Color getColor() {
        if(cnt%10==0) color=new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
        return color;
        //return Color.CYAN;
    }

    @Override
    public Action getMove(CritterInfo info) {
        cnt++;
        if(cnt>2000) cnt=1;
        if(cnt<1000){
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
            return Action.INFECT;
        }
        else{
            if(info.getFront().equals(Neighbor.OTHER)) return Action.INFECT;
            else if(info.getFront().equals(Neighbor.EMPTY)) return Action.HOP;
            if(info.getRight().equals(Neighbor.EMPTY) || info.getRight().equals(Neighbor.OTHER)) return Action.RIGHT;
            if(info.getLeft().equals(Neighbor.EMPTY) || info.getLeft().equals(Neighbor.OTHER)) return Action.LEFT;
            if(info.getBack().equals(Neighbor.EMPTY) || info.getBack().equals(Neighbor.OTHER)) return Action.RIGHT;
            return Action.INFECT;
        }
    }

    @Override
    public String toString() {
        return (char) cnt+"";
        //return "`";
    }
}
