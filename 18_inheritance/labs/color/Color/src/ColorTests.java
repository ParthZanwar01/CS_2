import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
class ColorTest {
    @Test
    void getRed() {
        Color test = new Color();
        assertEquals(0, test.getRed());
        Color testTwo = new Color(Integer.MAX_VALUE, Byte.MIN_VALUE, ~-127);
        assertEquals(255, testTwo.getRed());
        testTwo.setRed(Integer.MIN_VALUE);
        assertEquals(0, testTwo.getRed());
    }
    @Test
    void setRed() {
        Color test = new Color();
        assertEquals(0, test.getRed());
        Color testTwo = new Color(Integer.MAX_VALUE, Byte.MIN_VALUE, ~-127);
        assertEquals(255, testTwo.getRed());
        testTwo.setRed(Integer.MIN_VALUE);
        assertEquals(0, testTwo.getRed());
    }
    @Test
    void getGreen() {
        Color test = new Color();
        assertEquals(0, test.getRed());
        Color testTwo = new Color(Integer.MAX_VALUE, Byte.MIN_VALUE, ~-127);
        assertEquals(0, testTwo.getGreen());
        testTwo.setGreen(Integer.MIN_VALUE);
        assertEquals(0, testTwo.getGreen());
    }
    @Test
    void setGreen() {
        Color test = new Color();
        assertEquals(0, test.getRed());
        Color testTwo = new Color(Integer.MAX_VALUE, Byte.MIN_VALUE, ~-127);
        assertEquals(0, testTwo.getGreen());
        testTwo.setGreen(Integer.MIN_VALUE);
        assertEquals(0, testTwo.getGreen());
    }
    @Test
    void getBlue() {
        Color test = new Color();
        assertEquals(0, test.getBlue());
        Color testTwo = new Color(122, 255, 18);
        assertEquals(18, testTwo.getBlue());
        testTwo.setBlue(900);
        assertEquals(255, testTwo.getBlue());
        testTwo.setBlue(Integer.MIN_VALUE);
        assertEquals(0, testTwo.getBlue());
    }
    @Test
    void setBlue() {
        Color test = new Color();
        assertEquals(0, test.getBlue());
        Color testTwo = new Color(122, 255, 18);
        assertEquals(18, testTwo.getBlue());
        testTwo.setBlue(900);
        assertEquals(255, testTwo.getBlue());
        testTwo.setBlue(Integer.MIN_VALUE);
        assertEquals(0, testTwo.getBlue());
        testTwo.setBlue(~-127);
        assertEquals(126, testTwo.getBlue());
    }
    @Test
    void testToString() {
        Color test = new Color();
        assertEquals("#(0,0,0)", test.toString());
        Color testTwo = new Color(127, 120, 432890);
        assertEquals("#(127,120,255)", testTwo.toString());
        testTwo.setBlue(~Byte.MAX_VALUE);
        assertEquals("#(127,120,0)", testTwo.toString());
        Color testThree = new Color(Short.MIN_VALUE, Integer.MAX_VALUE, 16);
        assertEquals("#(0,255,16)", testThree.toString());
    }
}