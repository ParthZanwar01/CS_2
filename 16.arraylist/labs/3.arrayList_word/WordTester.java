import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WordTester {

    @Test(timeout = 200)
    public void test1() {
        Word w = new Word("chicken");
        assertEquals(w.getNumVowels(), 2);
        assertEquals(w.getLength(), 7);
    }

    @Test(timeout = 200)
    public void test2() {
        Word w = new Word("alligator");
        assertEquals(w.getNumVowels(), 4);
        assertEquals(w.getLength(), 9);
    }

    @Test(timeout = 200)
    public void test3() {
        Word w = new Word("elephant");
        assertEquals(w.getNumVowels(), 3);
        assertEquals(w.getLength(), 8);
    }
}
