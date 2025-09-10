import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NumberTester {

    @Test(timeout = 200)
    public void test1() {
        Number n = new Number(7);
        assertTrue(n.isOdd());
        assertFalse(n.isPerfect());
    }

    @Test(timeout = 200)
    public void test2() {
        Number n = new Number(28);
        assertFalse(n.isOdd());
        assertTrue(n.isPerfect());
    }

    @Test(timeout = 200)
    public void test3() {
        Number n = new Number(496);
        assertFalse(n.isOdd());
        assertTrue(n.isPerfect());
    }

    @Test(timeout = 200)
    public void test4() {
        Number n = new Number(1111);
        assertTrue(n.isOdd());
        assertFalse(n.isPerfect());
    }

    @Test(timeout = 200)
    public void test5() {
        Number n = new Number(199);
        assertTrue(n.isOdd());
        assertFalse(n.isPerfect());
    }

    @Test(timeout = 200)
    public void test6() {
        Number n = new Number(201);
        assertTrue(n.isOdd());
        assertFalse(n.isPerfect());
    }

    @Test(timeout = 200)
    public void test7() {
        Number n = new Number(17);
        assertTrue(n.isOdd());
        assertFalse(n.isPerfect());

    }
}
