import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class myStringBuilderTester {

    @Test(timeout = 200)
    public void testBasicConstructor(){
        MyStrBuilder msb = new MyStrBuilder();
        assertEquals(msb.capacity(), 16);
        assertEquals(msb.length(), 0);
    }

    @Test(timeout = 200)
    public void testConstructor1(){
        MyStrBuilder msb = new MyStrBuilder(30);
        assertEquals(msb.capacity(), 30);
        assertEquals(msb.length(), 0);
    }

    @Test(timeout = 200)
    public void testConstructor2(){
        MyStrBuilder msb = new MyStrBuilder(121);
        assertEquals(msb.capacity(), 121);
        assertEquals(msb.length(), 0);
    }

    @Test(timeout = 200)
    public void testConstructor3(){
        MyStrBuilder msb = new MyStrBuilder(1000);
        assertEquals(msb.capacity(), 1000);
        assertEquals(msb.length(), 0);
    }

    @Test(timeout = 200)
    public void testConstructor4(){
        MyStrBuilder msb = new MyStrBuilder("Java".toCharArray());
        assertEquals(msb.capacity(), 20);
        assertEquals(msb.length(), 4);
    }

    @Test(timeout = 200)
    public void testConstructor5(){
        MyStrBuilder msb = new MyStrBuilder("Hello World".toCharArray());
        assertEquals(msb.capacity(), 27);
        assertEquals(msb.length(), 11);
    }

    @Test(timeout = 200)
    public void testConstructor6(){
        MyStrBuilder msb = new MyStrBuilder("123456789012345678901234567890".toCharArray());
        assertEquals(msb.capacity(), 46);
        assertEquals(msb.length(), 30);
    }

    @Test(timeout = 200)
    public void testAppendChar1(){
        MyStrBuilder msb = new MyStrBuilder();
        msb.append('c');
        assertEquals(msb, new MyStrBuilder(new char[]{'c'}));
    }

    @Test(timeout = 200)
    public void testAppendChar2(){
        MyStrBuilder msb = new MyStrBuilder("Java".toCharArray());
        msb.append('s');
        assertEquals(msb, new MyStrBuilder("Javas".toCharArray()));
    }

    @Test(timeout = 200)
    public void testAppendChar3(){
        MyStrBuilder msb = new MyStrBuilder(16);
        msb.append('s');
        assertEquals(msb, new MyStrBuilder("s".toCharArray()));
    }

    @Test(timeout = 200)
    public void testAppendInt1(){
        MyStrBuilder msb = new MyStrBuilder(19);
        MyStrBuilder msb2 = new MyStrBuilder(new char[] {'1', '2', '3'});
        msb.append(123);
        assertEquals(msb.getData().length, msb.getData().length);
        assertEquals(Arrays.toString(msb.getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testAppendInt2(){
        MyStrBuilder msb = new MyStrBuilder();
        msb.append(-123);
        assertEquals(msb, new MyStrBuilder("-123".toCharArray()));
    }

    @Test(timeout = 200)
    public void testAppendInt3(){
        MyStrBuilder msb = new MyStrBuilder();
        MyStrBuilder msb2 = new MyStrBuilder();
        msb.append(-123+240);
        msb2.append(117);
        assertEquals(Arrays.toString(msb.getData()), Arrays.toString(msb2.getData()));
    }



    @Test(timeout = 200)
    public void testAppendCharArray1(){
        MyStrBuilder msb = new MyStrBuilder(21);
        MyStrBuilder msb2 = new MyStrBuilder("Ranch".toCharArray());
        msb.append("Ranch".toCharArray());
        assertEquals(msb.capacity(), msb2.capacity());
        assertEquals(Arrays.toString(msb.getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testInsertChar1(){
        MyStrBuilder msb = new MyStrBuilder();
        msb.append(new char[]{'J','a','v','a'});
        msb.insert(1, 'J');
        assertEquals(msb, new MyStrBuilder(new char[]{'J', 'J', 'a', 'v', 'a'}));
    }

    @Test(timeout = 200)
    public void testInsertCharArray1(){
        MyStrBuilder msb = new MyStrBuilder();
        msb.append("Know power".toCharArray());
        msb.insert(4, "ledge is".toCharArray());
        assertEquals(msb, new MyStrBuilder("Knowledge is power".toCharArray()));
    }

    @Test(timeout = 200)
    public void testDeleteChar1(){
        MyStrBuilder msb = new MyStrBuilder();
        msb.append("Java".toCharArray());
        msb.delete(2);
        assertEquals(msb, new MyStrBuilder("Jaa".toCharArray()));
    }

    @Test(timeout = 0)
    public void testDeleteCharArray1(){
        MyStrBuilder msb = new MyStrBuilder();
        MyStrBuilder msb2 = new MyStrBuilder();
        msb2.append("Ja".toCharArray());
        msb.append("Java".toCharArray());
        msb.delete(2, 4);
        assertEquals(msb.capacity(), 16);
        assertEquals(Arrays.toString(msb.getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testReverse1(){
        MyStrBuilder msb1 = new MyStrBuilder();
        MyStrBuilder msb2 = new MyStrBuilder();
        msb1.append(123);
        msb1.reverse();
        msb2.append(321);
        assertEquals(Arrays.toString(msb1.getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testReverse2(){
        MyStrBuilder msb1 = new MyStrBuilder();
        MyStrBuilder msb2 = new MyStrBuilder();
        msb1.append("Java".toCharArray());
        msb1.reverse();
        msb2.append("avaJ".toCharArray());
        assertEquals(Arrays.toString(msb1.getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testReverse3(){
        MyStrBuilder msb1 = new MyStrBuilder();
        MyStrBuilder msb2 = new MyStrBuilder();
        msb1.append('1');
        msb1.reverse();
        msb2.append('1');
        assertEquals(Arrays.toString(msb1.getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testToUpperCase1(){
        MyStrBuilder msb = new MyStrBuilder(new char[] {'a', 'b', 'c'});
        MyStrBuilder msb2 = new MyStrBuilder(new char[] {'A', 'B', 'C', });
        assertEquals(19, msb.toUpperCase().capacity());
        assertEquals(Arrays.toString(msb.toUpperCase().getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testToUpperCase2(){
        MyStrBuilder msb = new MyStrBuilder("hello world".toCharArray());
        MyStrBuilder msb2 = new MyStrBuilder("HELLO WORLD".toCharArray());
        assertEquals(27, msb.toUpperCase().capacity());
        assertEquals(Arrays.toString(msb.toUpperCase().getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testReplace1(){
        MyStrBuilder msb = new MyStrBuilder("hello world".toCharArray());
        MyStrBuilder msb2 = new MyStrBuilder(27);
        msb2.append("hello goodbye".toCharArray());
        msb.replace(6, "goodbye".toCharArray());
        assertEquals(msb.capacity(), 27);
        assertEquals(Arrays.toString(msb.getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testReplace2(){
        MyStrBuilder msb = new MyStrBuilder("hello werld".toCharArray());
        MyStrBuilder msb2 = new MyStrBuilder(27);
        msb2.append("hello world".toCharArray());
        msb.replace(7, new char[] {'o'});
        assertEquals(27, msb.capacity());
        assertEquals(Arrays.toString(msb.getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testToLowerCase1(){
        MyStrBuilder msb = new MyStrBuilder(new char[] {'a', 'b', 'c'});
        MyStrBuilder msb2 = new MyStrBuilder(new char[] {'A', 'B', 'C', });
        assertEquals(19, msb2.toLowerCase().capacity());
        assertEquals(Arrays.toString(msb.getData()), Arrays.toString(msb2.toLowerCase().getData()));
        assertEquals(Arrays.toString(msb2.getData()), Arrays.toString(new MyStrBuilder("ABC".toCharArray()).getData()));
    }

    @Test(timeout = 200)
    public void testToLowerCase2(){
        MyStrBuilder msb = new MyStrBuilder("hello world1".toCharArray());
        MyStrBuilder msb2 = new MyStrBuilder("HELLO WORLD1".toCharArray());
        assertEquals(28, msb2.toLowerCase().capacity());
        assertEquals(Arrays.toString(msb.getData()), Arrays.toString(msb2.toLowerCase().getData()));
        assertEquals(Arrays.toString(msb2.getData()), Arrays.toString(new MyStrBuilder("HELLO WORLD1".toCharArray()).getData()));
    }

    @Test(timeout = 200)
    public void testToLowerCase3(){
        MyStrBuilder msb = new MyStrBuilder("hellowbsobdogbobdob".toCharArray());
        MyStrBuilder msb2 = new MyStrBuilder("HelLowBSobdogbobdob".toCharArray());
        assertEquals(35, msb2.toLowerCase().capacity());
        assertEquals(Arrays.toString(msb.getData()), Arrays.toString(msb2.toLowerCase().getData()));
        assertEquals(Arrays.toString(msb2.getData()), Arrays.toString(new MyStrBuilder("HelLowBSobdogbobdob".toCharArray()).getData()));
    }

    @Test(timeout = 200)
    public void testSubstring1(){
        //                                   0123456789012345678901234
        MyStrBuilder msb = new MyStrBuilder("Cypress Ranch High School".toCharArray());
        MyStrBuilder msb2 = new MyStrBuilder("High School".toCharArray());
        MyStrBuilder ret = msb.substring(14, 25);
        assertEquals(ret.capacity(), msb2.capacity());
        assertEquals(Arrays.toString(ret.getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testSubstring2(){
        //                                   0123456789012345678901234
        MyStrBuilder msb = new MyStrBuilder("Cypress Ranch High School".toCharArray());
        MyStrBuilder msb2 = new MyStrBuilder();
        msb2.append("Ranch High School".toCharArray());
        MyStrBuilder ret = msb.substring(8);
        assertEquals(ret.capacity(), msb2.capacity());
        assertEquals(Arrays.toString(ret.getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testSubstring3(){
        //                                   01234567890123456789012
        MyStrBuilder msb = new MyStrBuilder("Parth Zanwar, Sophomore".toCharArray());
        MyStrBuilder msb2 = new MyStrBuilder("Sophomor".toCharArray());
        MyStrBuilder ret = msb.substring(14, 22);
        assertEquals(ret.capacity(), msb2.capacity());
        assertEquals(Arrays.toString(ret.getData()), Arrays.toString(msb2.getData()));
    }

    @Test(timeout = 200)
    public void testIndexOf1(){
        //                                   0123456789012345678
        MyStrBuilder msb = new MyStrBuilder("Hey, how you doing?".toCharArray());
        assertEquals(msb.indexOf('H'), 0);
    }

    @Test(timeout = 200)
    public void testIndexOf2(){
        //                                   0123456789012345678
        MyStrBuilder msb = new MyStrBuilder("Hey, how you doing?".toCharArray());
        assertEquals(msb.indexOf('o'), 6);
    }

    @Test(timeout = 200)
    public void testIndexOf3(){
        //                                   0123456789012345678
        MyStrBuilder msb = new MyStrBuilder("Hey, how you doing?".toCharArray());
        assertEquals(msb.indexOf('t'), -1);
    }

    @Test(timeout = 200)
    public void testCharAt1(){
        //                                   0123456789012345678
        MyStrBuilder msb = new MyStrBuilder("Hey, how you doing?".toCharArray());
        assertEquals(msb.charAt(msb.length()-1), '?');
    }

    @Test(timeout = 200)
    public void testCharAt2(){
        //                                   0123456789012345678
        MyStrBuilder msb = new MyStrBuilder("Hey, how you doing?".toCharArray());
        assertEquals(msb.charAt(msb.length()-1), '?');
    }

    @Test(timeout = 200)
    public void testCharAt3(){
        //                                   0123456789012345678
        MyStrBuilder msb = new MyStrBuilder("Hey, how you doing?".toCharArray());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            msb.charAt(-1);
        });
    }

    @Test(timeout = 200)
    public void testCharAt4(){
        //                                   0123456789012345678
        MyStrBuilder msb = new MyStrBuilder("Hey, how you doing?".toCharArray());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            msb.charAt(msb.length());
        });
    }
}
