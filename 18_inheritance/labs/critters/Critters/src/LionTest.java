
import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

public class LionTest {

    /**
     * Test of getMove method - "INFECT", of class Lion.
     *
     * always infect if an enemy is in front
     */
    @Test
    public void testGetMove1() {
        System.out.println("Lion  getMove 1");
        Lion instance = new Lion();

        Critter.Neighbor[] neighbors = {Critter.Neighbor.OTHER, Critter.Neighbor.WALL, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        Critter.Direction d = Critter.Direction.NORTH;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);

        Critter.Action expResult = Critter.Action.INFECT;
        Critter.Action result = instance.getMove(info);
        assertEquals(expResult, result);

        d = Critter.Direction.SOUTH;
        result = instance.getMove(info);
        assertEquals(expResult, result);

        d = Critter.Direction.EAST;
        result = instance.getMove(info);
        assertEquals(expResult, result);

        d = Critter.Direction.WEST;
        result = instance.getMove(info);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMove method "LEFT", of class Lion. always infect if an enemy
     * is in front, otherwise if a wall is in front or to the right, then turn
     * left
     */
    @Test
    public void testGetMove2() {
        System.out.println("Lion  getMove 2");
        Lion instance = new Lion();

        Critter.Neighbor[] neighbors = {Critter.Neighbor.WALL, Critter.Neighbor.WALL, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        Critter.Direction d = Critter.Direction.NORTH;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);

        Critter.Action expResult = Critter.Action.LEFT;
        Critter.Action result = instance.getMove(info);
        assertEquals(expResult, result);

        neighbors = new Critter.Neighbor[]{Critter.Neighbor.WALL, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);
        result = instance.getMove(info);
        assertEquals(expResult, result);

        neighbors = new Critter.Neighbor[]{Critter.Neighbor.EMPTY, Critter.Neighbor.WALL, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);
        result = instance.getMove(info);
        assertEquals(expResult, result);
    }

     /**
     * Test of getMove method - "RIGHT", of class Lion.
     *
     * always infect if an enemy is in front
     * otherwise if a wall is in front or to the right, then turn left
     * otherwise if a fellow Lion is in front, then turn right
     */
    @Test
    public void testGetMove3() {
        System.out.println("Lion  getMove 3");
        Lion instance = new Lion();

        Critter.Neighbor[] neighbors = {Critter.Neighbor.SAME, Critter.Neighbor.EMPTY, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        Critter.Direction d = Critter.Direction.NORTH;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);

        Critter.Action expResult = Critter.Action.RIGHT;
        Critter.Action result = instance.getMove(info);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getMove method - "HOP", of class Lion.
     *
     * always infect if an enemy is in front
     * otherwise if a wall is in front or to the right, then turn left
     * otherwise if a fellow Lion is in front, then turn right
     * otherwise hop.
     */
    @Test
    public void testGetMove4() {
        System.out.println("Lion  getMove 4");
        Lion instance = new Lion();

        Critter.Neighbor[] neighbors = {Critter.Neighbor.EMPTY, Critter.Neighbor.EMPTY, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        Critter.Direction d = Critter.Direction.WEST;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.WEST, neighborDirections);

        Critter.Action expResult = Critter.Action.HOP;
        Critter.Action result = instance.getMove(info);
        assertEquals(expResult, result);
        
        neighbors = new Critter.Neighbor[]{Critter.Neighbor.EMPTY, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);
        result = instance.getMove(info);
        assertEquals(expResult, result);
        
        neighbors = new Critter.Neighbor[]{Critter.Neighbor.EMPTY, Critter.Neighbor.SAME, Critter.Neighbor.WALL, Critter.Neighbor.WALL};
        info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);
        result = instance.getMove(info);
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class Lion.
     */
    @Test
    public void testGetColor01() {
        System.out.println("Lion  getColor 1");
        Lion instance = new Lion();

        Color result = instance.getColor();
        boolean b = result.equals(Color.red) || result.equals(Color.green) || result.equals(Color.blue);
        assertTrue(b);

        Critter.Neighbor[] neighbors = {Critter.Neighbor.OTHER, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        Critter.Direction d = Critter.Direction.NORTH;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);

        Color expResult = result;
        for (int i = 0; i < 2; i++) {
            instance.getMove(info);
            result = instance.getColor();
            assertEquals(expResult, result);
        }

    }

    /**
     * Test of getColor method, of class Lion.
     */
    @Test
    public void testGetColor02() {
        System.out.println("Lion  getColor 2");
        Lion instance = new Lion();

        Critter.Neighbor[] neighbors = {Critter.Neighbor.OTHER, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER, Critter.Neighbor.OTHER};
        Critter.Direction d = Critter.Direction.NORTH;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);

	int cnt = 0;
        for (int cases = 0; cases < 500; cases++) {
            Color result = instance.getColor();
            //boolean b = result.equals(Color.red) || result.equals(Color.green) || result.equals(Color.blue);
            boolean b = false; 
            if(result.equals(Color.red)){
                  b = true;
                  cnt++;
            }else if(result.equals(Color.green)){
                  b = true;
                  cnt++;
            }else if(result.equals(Color.blue)){
                  b = true;
                  cnt++;
            }
            assertTrue(b);

            Color expResult = result;
            for (int i = 0; i < 2; i++) {
                instance.getMove(info);
                result = instance.getColor();
                assertEquals(expResult, result);
            }
            instance.getMove(info);
        }
        assertEquals(cnt, 500);
    }

    /**
     * Test of toString method, of class Lion.
     */
    @Test
    public void testToString1() {
        System.out.println("Lion  toString 1");
        Lion instance = new Lion();
        String expResult = "L";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
