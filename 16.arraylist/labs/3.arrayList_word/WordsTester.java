import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WordsTester {

    @Test(timeout = 200)
    public void test1() {
        Words w = new Words("one, two, three, four, five, six, seven, alligator");
        assertEquals(w.countWordsWithXVowels(2), 5);
        assertEquals(w.countWordsWithXVowels(3), 0);
        assertEquals(w.countWordsWithXVowels(4), 1);
        assertEquals(w.countWordsWithXChars(2), 0);
        assertEquals(w.countWordsWithXChars(3), 3);
        assertEquals(w.countWordsWithXChars(4), 2);
        assertEquals(w.countWordsWithXChars(5), 2);
        assertEquals(w.removeWordsWithXChars(3), 4);
        assertEquals(w.countWordsWithXChars(3), 0);
    }

    @Test(timeout = 200)
    public void test2() {
        Words w = new Words("fun, fly, four, six, times, ten, plus, eight");
        assertEquals(w.countWordsWithXVowels(2), 3);
        assertEquals(w.countWordsWithXVowels(3), 0);
        assertEquals(w.countWordsWithXVowels(4), 0);
        assertEquals(w.countWordsWithXChars(2), 0);
        assertEquals(w.countWordsWithXChars(3), 4);
        assertEquals(w.countWordsWithXChars(4), 2);
        assertEquals(w.countWordsWithXChars(5), 2);
        assertEquals(w.removeWordsWithXChars(3), 3);
        assertEquals(w.countWordsWithXChars(3), 0);
    }

    @Test(timeout = 200)
    public void test3() {
        Words w = new Words("alligator, chicken, dog, cat, pig, buffalo");
        assertEquals(w.countWordsWithXVowels(2), 1);
        assertEquals(w.countWordsWithXVowels(3), 1);
        assertEquals(w.countWordsWithXVowels(4), 1);
        assertEquals(w.countWordsWithXChars(2), 0);
        assertEquals(w.countWordsWithXChars(3), 3);
        assertEquals(w.countWordsWithXChars(4), 0);
        assertEquals(w.countWordsWithXChars(9), 1);
        assertEquals(w.removeWordsWithXChars(3), 3);
        assertEquals(w.countWordsWithXChars(3), 0);
    }
}
