import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.*;

public class TriangleFiveTest {

    @Test(timeout = 1000)
    public void setLetter() {
        TriangleFive test = new TriangleFive('g', 5);
        test.setLetter('A');
        String exp = "AAAAA BBBB CCC DD E\n" +
                "AAAAA BBBB CCC DD\n" +
                "AAAAA BBBB CCC\n" +
                "AAAAA BBBB\n" +
                "AAAAA";
        String result = test.toString().trim();
        assertEquals(exp, result);

    }

    @Test(timeout = 1000)
    public void setAmount() {
        TriangleFive test = new TriangleFive('C', 8);
        test.setAmount(4);
        String exp = "CCCC DDD EE F\n" +
                "CCCC DDD EE\n" +
                "CCCC DDD\n" +
                "CCCC";
        String result = test.toString().trim();
        assertEquals(exp, result);
    }

    @Test(timeout = 1000)
    public void testToString() {
        TriangleFive test = new TriangleFive('x', 6);
        test.setLetter('X');
        test.setAmount(6);
        String exp = "XXXXXX YYYYY ZZZZ AAA BB C\n" +
                "XXXXXX YYYYY ZZZZ AAA BB\n" +
                "XXXXXX YYYYY ZZZZ AAA\n" +
                "XXXXXX YYYYY ZZZZ\n" +
                "XXXXXX YYYYY\n" +
                "XXXXXX";
        String result = test.toString().trim();
        assertEquals(exp, result);
    }

    @Test(timeout = 1000)
    public void testToString2() {
        TriangleFive test = new TriangleFive('B', 7);
        String exp = "BBBBBBB CCCCCC DDDDD EEEE FFF GG H\n" +
                "BBBBBBB CCCCCC DDDDD EEEE FFF GG\n" +
                "BBBBBBB CCCCCC DDDDD EEEE FFF\n" +
                "BBBBBBB CCCCCC DDDDD EEEE\n" +
                "BBBBBBB CCCCCC DDDDD\n" +
                "BBBBBBB CCCCCC\n" +
                "BBBBBBB";
        String result = test.toString().trim();
        assertEquals(exp, result);
    }

    @Test(timeout = 1000)
    public void testToString3() {
        TriangleFive test = new TriangleFive('W', 9);
        String exp = "WWWWWWWWW XXXXXXXX YYYYYYY ZZZZZZ AAAAA BBBB CCC DD E\n" +
                "WWWWWWWWW XXXXXXXX YYYYYYY ZZZZZZ AAAAA BBBB CCC DD\n" +
                "WWWWWWWWW XXXXXXXX YYYYYYY ZZZZZZ AAAAA BBBB CCC\n" +
                "WWWWWWWWW XXXXXXXX YYYYYYY ZZZZZZ AAAAA BBBB\n" +
                "WWWWWWWWW XXXXXXXX YYYYYYY ZZZZZZ AAAAA\n" +
                "WWWWWWWWW XXXXXXXX YYYYYYY ZZZZZZ\n" +
                "WWWWWWWWW XXXXXXXX YYYYYYY\n" +
                "WWWWWWWWW XXXXXXXX\n" +
                "WWWWWWWWW";
        String result = test.toString().trim();
        assertEquals(exp, result);
    }
}