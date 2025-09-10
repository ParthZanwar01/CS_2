import org.junit.Test;

import static org.junit.Assert.*;

public class TriplesTest {

    @Test(timeout = 200)
    public void setNum() {
        Triples test = new Triples(14);
        test.setNum(8);
        String exp = "3 4 5";
        String result = test.toString().trim();
        assertEquals(exp, result);

    }

    @Test(timeout = 200)
    public void testToString() {
        Triples test = new Triples(29);
        String exp = "3 4 5\n" +
                "5 12 13\n" +
                "7 24 25\n" +
                "8 15 17";
        String result = test.toString().trim();
        assertEquals(exp, result);
    }

    @Test(timeout = 200)
    public void testToString2() {
        Triples test = new Triples(120);
        String exp = "3 4 5\n" +
                "5 12 13\n" +
                "7 24 25\n" +
                "8 15 17\n" +
                "9 40 41\n" +
                "11 60 61\n" +
                "12 35 37\n" +
                "13 84 85\n" +
                "15 112 113\n" +
                "16 63 65\n" +
                "20 21 29\n" +
                "20 99 101\n" +
                "28 45 53\n" +
                "33 56 65\n" +
                "36 77 85\n" +
                "39 80 89\n" +
                "48 55 73\n" +
                "60 91 109\n" +
                "65 72 97";
        String result = test.toString().trim();
        assertEquals(exp, result);
    }

    @Test(timeout = 400)
    public void testToString3() {
        Triples test = new Triples(300);
        String exp = "3 4 5\n" +
                "5 12 13\n" +
                "7 24 25\n" +
                "8 15 17\n" +
                "9 40 41\n" +
                "11 60 61\n" +
                "12 35 37\n" +
                "13 84 85\n" +
                "15 112 113\n" +
                "16 63 65\n" +
                "17 144 145\n" +
                "19 180 181\n" +
                "20 21 29\n" +
                "20 99 101\n" +
                "21 220 221\n" +
                "23 264 265\n" +
                "24 143 145\n" +
                "28 45 53\n" +
                "28 195 197\n" +
                "32 255 257\n" +
                "33 56 65\n" +
                "36 77 85\n" +
                "39 80 89\n" +
                "44 117 125\n" +
                "48 55 73\n" +
                "51 140 149\n" +
                "52 165 173\n" +
                "57 176 185\n" +
                "60 91 109\n" +
                "60 221 229\n" +
                "65 72 97\n" +
                "68 285 293\n" +
                "69 260 269\n" +
                "84 187 205\n" +
                "85 132 157\n" +
                "88 105 137\n" +
                "95 168 193\n" +
                "96 247 265\n" +
                "104 153 185\n" +
                "105 208 233\n" +
                "115 252 277\n" +
                "119 120 169\n" +
                "120 209 241\n" +
                "133 156 205\n" +
                "140 171 221\n" +
                "160 231 281\n" +
                "161 240 289";
        String result = test.toString().trim();
        assertEquals(exp, result);
    }
}