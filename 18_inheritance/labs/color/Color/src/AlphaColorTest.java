import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class AlphaColorTest {
    @Test
    void getAlpha() {
        AlphaColor test = new AlphaColor(0, 255, 0, 255);
        assertEquals(255, test.getAlpha());
    }
    @Test
    void dissolve() {
        AlphaColor test = new AlphaColor(0, 255, 0, 255);
        test.dissolve();
        assertEquals("#(1,255,1)(opaque:255)", test.toString());
        AlphaColor testTwo = new AlphaColor(300, 0, 0, 210);
        testTwo.dissolve();
        assertEquals("#(255,1,1)(opaque:211)", testTwo.toString());
        AlphaColor testThree = new AlphaColor(Integer.MIN_VALUE,
                Integer.MAX_VALUE, Byte.MAX_VALUE, 19);
        testThree.dissolve();
        assertEquals(1, test.getRed());
        assertEquals(20, testThree.getAlpha());
        assertEquals("#(1,255,128)(transparent:20)", testThree.toString());
    }
    @Test
    void precipitate() {
        AlphaColor test = new AlphaColor(255, 255, 255, 255);
        test.precipitate();
        assertEquals("#(254,254,254)(opaque:254)", test.toString());
        assertEquals(254, test.getRed());
        assertEquals(254, test.getBlue());
        assertEquals(254, test.getGreen());
        AlphaColor testTwo = new AlphaColor(~255, ~120, ~1, 17);
        testTwo.precipitate();
        assertEquals(0, testTwo.getRed());
        assertEquals(0, testTwo.getBlue());
        assertEquals(0, testTwo.getGreen());
        assertEquals(16, testTwo.getAlpha());
        assertEquals("#(0,0,0)(transparent:16)", testTwo.toString());
        AlphaColor testThree = new AlphaColor(100, 150, 217, 120);
        testThree.precipitate();
        assertEquals(99, testThree.getRed());
        assertEquals(149, testThree.getGreen());
        assertEquals(216, testThree.getBlue());
        assertEquals("#(99,149,216)(translucent:119)", testThree.toString());
        AlphaColor testFour = new AlphaColor(100, 126, 219, 1);
        testFour.precipitate();
        testFour.precipitate();
        assertEquals(98, testFour.getRed());
        assertEquals(124, testFour.getGreen());
        assertEquals(217, testFour.getBlue());
        assertEquals(0, testFour.getAlpha());
        assertEquals("#(98,124,217)(transparent:0)", testFour.toString());
        AlphaColor testFive = new AlphaColor(0.0, -0.3972, 0.9766, 0.1608, 157);
    }
    @Test
    void testToString() {
        AlphaColor test = new AlphaColor(0, 255, 0, 0);
        assertEquals("#(0,255,0)(transparent:0)", test.toString());
        AlphaColor testTwo = new AlphaColor(~Short.MAX_VALUE, ~Byte.MIN_VALUE +
                1, 12, 240);
        assertEquals("#(0,128,12)(opaque:240)", testTwo.toString());
        testTwo.dissolve();
        assertEquals("#(1,129,13)(opaque:241)", testTwo.toString());
        testTwo.precipitate();
        assertEquals("#(0,128,12)(opaque:240)", testTwo.toString());
        AlphaColor testThree = new AlphaColor(0.0, 0.4392156862745098, 1.0, 0.0, 200);
        assertEquals("#(255,143,0)(translucent:200)", testThree.toString());
        AlphaColor testFour = new AlphaColor(0.0, 0.3972, 0.9766, 0.1608, 240);
        assertEquals("#(214,129,5)(opaque:240)", testFour.toString());
        AlphaColor testFive = new AlphaColor(0.0, 1.3972, 0.9766, 0.1608, 240);
        assertEquals("#(214,0,5)(opaque:240)", testFive.toString());
        testFive.dissolve();
        assertEquals("#(215,1,6)(opaque:241)", testFive.toString());
        AlphaColor testSix = new AlphaColor(0.0, -0.3972, 0.9766, 0.1608, 157);
        assertEquals("#(214,255,5)(translucent:157)", testSix.toString());
    }
}