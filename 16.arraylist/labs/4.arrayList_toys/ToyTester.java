import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ToyTester {

    @Test(timeout = 200)
    public void test1() {
        Toy t = new Toy("sorry");
        assertEquals(t.getCount(), 1);
    }

    @Test(timeout = 200)
    public void test2() {
        Toy t = new Toy("gi joe", 5);
        assertEquals(t.getCount(), 5);
    }
}
