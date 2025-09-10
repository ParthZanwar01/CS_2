import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NumberAnalyzerTester {

    @Test(timeout = 200)
    public void test1() {
        NumberAnalyzer n = new NumberAnalyzer("5 12 9 6 1 4 8 6");
        assertEquals(n.countOdds(), 3);
        assertEquals(n.countEvens(), 5);
        assertEquals(n.countPerfects(), 2);
    }

    @Test(timeout = 200)
    public void test2() {
        NumberAnalyzer n = new NumberAnalyzer("5 12 3 7 28 496 81 65 33 11");
        assertEquals(n.countOdds(), 7);
        assertEquals(n.countEvens(), 3);
        assertEquals(n.countPerfects(), 2);
    }

    @Test(timeout = 200)
    public void test3() {
        NumberAnalyzer n = new NumberAnalyzer("1 2 3 4 5 6 7 8 11 13 151 16 17 18 19 20");
        assertEquals(n.countOdds(), 9);
        assertEquals(n.countEvens(), 7);
        assertEquals(n.countPerfects(), 1);
    }
}
