import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

public class BearTest {
    
    static final int FRONT = 0, BACK = 2, LEFT = 3, RIGHT = 1;
    
    /**
     * Test of getMove method - "INFECT", of class Bear.
     * always infect if an enemy is in front
     */
    @Test
    public void testGetMove1() {
        System.out.println("Bear  getMove 1");
        Bear instance = new Bear(false);
        
        Critter.Neighbor[] neighbors = {Critter.Neighbor.OTHER,Critter.Neighbor.OTHER,Critter.Neighbor.OTHER,Critter.Neighbor.OTHER};
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
     * Test of getMove method "HOP", of class Bear.
     * always infect if an enemy is in front,
     * otherwise hop if possible
     */
    @Test
    public void testGetMove2() {
        System.out.println("Bear  getMove 2");
        Bear instance = new Bear(true);
        
        Critter.Neighbor[] neighbors = {Critter.Neighbor.EMPTY,Critter.Neighbor.EMPTY,Critter.Neighbor.EMPTY,Critter.Neighbor.EMPTY};
        Critter.Direction d = Critter.Direction.NORTH;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);
        
        Critter.Action expResult = Critter.Action.HOP;
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
     * Test of getMove method "LEFT", of class Bear.
     * always infect if an enemy is in front,
     * otherwise hop if possible,
     * otherwise turn left
     */
    @Test
    public void testGetMove3() {
        System.out.println("Bear  getMove 3");
        Bear instance = new Bear(true);
        
        Critter.Neighbor[] neighbors = {Critter.Neighbor.WALL,Critter.Neighbor.WALL,Critter.Neighbor.WALL,Critter.Neighbor.WALL};
        Critter.Direction d = Critter.Direction.NORTH;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);
        
        Critter.Action expResult = Critter.Action.LEFT;
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
        
        neighbors = new Critter.Neighbor[]{Critter.Neighbor.SAME,Critter.Neighbor.SAME,Critter.Neighbor.SAME,Critter.Neighbor.SAME};
        d = Critter.Direction.NORTH;
        info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);
        
        result = instance.getMove(info);
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
     * Test of getColor method, of class Bear.
     */
    @Test
    public void testGetColor01() {
        System.out.println("Bear  getColor 1");
        Bear instance = new Bear(true);
        Color expResult = Color.white;
        Color result = instance.getColor();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getColor method, of class Bear.
     */
    @Test
    public void testGetColor02() {
        System.out.println("Bear  getColor 2");
        Bear instance = new Bear(false);
        Color expResult = Color.black;
        Color result = instance.getColor();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getColor method, of class Bear.
     * Color should not change if calling any methods.
     */
    @Test
    public void testGetColor03() {
        System.out.println("Bear  getColor 3");
        Bear instance = new Bear(false);
        
        Critter.Neighbor[] neighbors = new Critter.Neighbor[4];
        Critter.Direction d = Critter.Direction.WEST;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.WEST, neighborDirections);
        instance.getMove(info);
        Color expResult = Color.black;
        Color result = instance.getColor();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getColor method, of class Bear.
     * Color should not change if calling any methods.
     */
    @Test
    public void testGetColor04() {
        System.out.println("Bear  getColor 4");
        Bear instance = new Bear(false);
        
        Critter.Neighbor[] neighbors = new Critter.Neighbor[4];
        Critter.Direction d = Critter.Direction.SOUTH;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.SOUTH, neighborDirections);
        instance.toString();
        Color expResult = Color.black;
        Color result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Bear.
     */
    @Test
    public void testToString1() {
        System.out.println("Bear  toString 1");
        Bear instance = new Bear(false);
        String expResult = "/";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Bear.
     * "Be sure that your code is tied to actual moves made by a critter.  
     * For example, the bear is supposed to be displayed alternately as a slash 
     * or backslash.  This should happen as the getMove method is called.  "
     */
    @Test
    public void testToString2() {
        System.out.println("Bear  toString 2");
        Bear instance = new Bear(false);
        String expResult = "/";
        instance.toString(); // should not affect the slash
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Bear.
     * "Be sure that your code is tied to actual moves made by a critter.  
     * For example, the bear is supposed to be displayed alternately as a slash 
     * or backslash.  This should happen as the getMove method is called.  "
     */
    @Test
    public void testToString3() {
        System.out.println("Bear  toString 3");
        Bear instance = new Bear(false);
        String expResult = "\\";
        Critter.Neighbor[] neighbors = new Critter.Neighbor[4];
        Critter.Direction d = Critter.Direction.EAST;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.EAST, neighborDirections);
        instance.getMove(info);  // switch to \\
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    /**
     * Test of toString method, of class Bear.
     * "Be sure that your code is tied to actual moves made by a critter.  
     * For example, the bear is supposed to be displayed alternately as a slash 
     * or backslash.  This should happen as the getMove method is called.  "
     */
    @Test
    public void testToString4() {
        System.out.println("Bear  toString 4");
        Bear instance = new Bear(true);
        String expResult = "\\";
        Critter.Neighbor[] neighbors = new Critter.Neighbor[4];
        Critter.Direction d = Critter.Direction.NORTH;
        Critter.Direction[] neighborDirections = new Critter.Direction[4];
        CritterModel.Info info = new CritterModel.Info(neighbors, Critter.Direction.NORTH, neighborDirections);
        for (int i = 0; i < 9; i++) {
            instance.getMove(info);  // switch 9 times
        }
        
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
