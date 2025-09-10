import org.junit.Test;

import static org.junit.Assert.*;

public class BoxWordTest {

    @Test(timeout = 200)
    public void setWord() {
        BoxWord b = new BoxWord("hello");
        b.setWord("BOX");
        String s = b.toString().trim();
        String res = "BOX\n" +
                "O O\n" +
                "XOB";
        assertEquals(s, res);

    }

    @Test(timeout = 200)
    public void testToString() {
        BoxWord b = new BoxWord("elephant");
        String s = b.toString().trim();
        String res = "elephant\n" +
                "l      n\n" +
                "e      a\n" +
                "p      h\n" +
                "h      p\n" +
                "a      e\n" +
                "n      l\n" +
                "tnahpele";
        assertEquals(s, res);
    }

    @Test(timeout = 200)
    public void testToString2() {
        BoxWord b = new BoxWord("FROG");
        String s = b.toString().trim();
        String res = "FROG\n" +
                "R  O\n" +
                "O  R\n" +
                "GORF";
        assertEquals(s, res);
    }

    @Test(timeout = 200)
    public void testToString3() {
        BoxWord b = new BoxWord("IT");
        String s = b.toString().trim();
        String res = "IT\n" +
                "TI";
        assertEquals(s, res);
    }

    @Test(timeout = 200)
    public void testToString4() {
        BoxWord b = new BoxWord("h");
        String s = b.toString().trim();
        String res = "h";
        assertEquals(s, res);
    }
}