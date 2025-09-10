
import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

public class GiantTest {

    /**
     * Test of getMove method - "INFECT", of class Giant.
     *
     * always infect if an enemy is in front
     */
    @Test
    public void testGetMove1() {
        System.out.println("Giant  getMove 1");
        Giant instance = new Giant();

        Critter.Neighbor[] neighbors = {Critter.Neighbor.OTHER, Critter.Neighbor.WALL, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        Critter.Direction d = Critter.Direction.EAST;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.EAST, neighborDirections);

        Critter.Action expResult = Critter.Action.INFECT;
        Critter.Action result = instance.getMove(info);
        assertEquals(expResult, result);

        d = Critter.Direction.SOUTH;
        result = instance.getMove(info);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMove method - "HOP", of class Giant.
     *
     * always infect if an enemy is in front
     * otherwise hop if possible
     */
    @Test
    public void testGetMove2() {
        System.out.println("Giant  getMove 2");
        Giant instance = new Giant();

        Critter.Neighbor[] neighbors = {Critter.Neighbor.EMPTY, Critter.Neighbor.WALL, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        Critter.Direction d = Critter.Direction.EAST;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.EAST, neighborDirections);

        Critter.Action expResult = Critter.Action.HOP;
        Critter.Action result = instance.getMove(info);
        assertEquals(expResult, result);

        d = Critter.Direction.SOUTH;
        
        neighbors = new Critter.Neighbor[]{Critter.Neighbor.EMPTY, Critter.Neighbor.WALL, Critter.Neighbor.SAME, Critter.Neighbor.WALL};
        info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);
        result = instance.getMove(info);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMove method - "RIGHT", of class Giant.
     *
     * always infect if an enemy is in front
     * otherwise hop if possible
     * otherwise turn right.
     */
    @Test
    public void testGetMove3() {
        System.out.println("Giant  getMove 3");
        Giant instance = new Giant();

        Critter.Neighbor[] neighbors = {Critter.Neighbor.SAME, Critter.Neighbor.WALL, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        Critter.Direction d = Critter.Direction.EAST;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.EAST, neighborDirections);

        Critter.Action expResult = Critter.Action.RIGHT;
        Critter.Action result = instance.getMove(info);
        assertEquals(expResult, result);

        d = Critter.Direction.SOUTH;
        
        neighbors = new Critter.Neighbor[]{Critter.Neighbor.WALL, Critter.Neighbor.WALL, Critter.Neighbor.SAME, Critter.Neighbor.WALL};
        info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);
        result = instance.getMove(info);
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class Giant.
     */
    @Test
    public void testGetColor01() {
        System.out.println("Giant  getColor 1");
        Giant instance = new Giant();
        Color expResult = Color.GRAY;
        Color result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Giant.
     */
    @Test
    public void testToString1() {
        System.out.println("Giant  toString 1");
        Giant instance = new Giant();
        String expResult = "fee";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Giant.
     */
    @Test
    public void testToString2() {
        System.out.println("Giant  toString 2");
        Giant instance = new Giant();
        String expResult = "fie";

        Critter.Neighbor[] neighbors = {Critter.Neighbor.EMPTY, Critter.Neighbor.EMPTY, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        Critter.Direction d = Critter.Direction.WEST;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.WEST, neighborDirections);

        for (int i = 0; i < 6; i++) {
            instance.getMove(info);
        }

        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Giant.
     */
    @Test
    public void testToString3() {
        System.out.println("Giant  toString 3");
        Giant instance = new Giant();
        String[] expResult = {"fee", "fie", "foe", "fum"};

        Critter.Neighbor[] neighbors = {Critter.Neighbor.EMPTY, Critter.Neighbor.EMPTY, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        Critter.Direction d = Critter.Direction.WEST;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.WEST, neighborDirections);

        for (int i = 0; i < 600; i++) {
            String result = instance.toString();
            assertEquals(expResult[i/6%4], result);
            instance.getMove(info);
        }
    }
}
