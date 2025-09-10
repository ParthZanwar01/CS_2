//import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleThreeTest {

    @Test(timeout = 50)
    public void testTestToString() {
        TriangleThree test = new TriangleThree(3,"A");
        String s = "  A\n" +
                " AA\n" +
                "AAA";
    }
    @Test(timeout = 50)
    public void testTestToString2() {
        TriangleThree test = new TriangleThree(3,"A");
        String s = "      X\n" +
                "     XX\n" +
                "    XXX\n" +
                "   XXXX\n" +
                "  XXXXX\n" +
                " XXXXXX\n" +
                "XXXXXXX";
    }

    @Test(timeout = 50)
    public void testTestToString3() {
        TriangleThree test = new TriangleThree(3,"A");
        String s = "R";
    }
    @Test(timeout = 50)
    public void testTestToString4() {
        TriangleThree test = new TriangleThree(3,"A");
        String s = "    T\n" +
                "   TT\n" +
                "  TTT\n" +
                " TTTT\n" +
                "TTTTT";
    }
    @Test(timeout = 50)
    public void testTestToString5() {
        TriangleThree test = new TriangleThree(3,"A");
        String s = "   W\n" +
                "  WW\n" +
                " WWW\n" +
                "WWWW";
    }
}