
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PartCTest {
    /**
     * Test of bisectionMonthlyAmount method, of class CreditCards.
     */
    @Test
    public void testBisectionMonthlyAmount() {
        String expResult = "" + 29157.09;
        String result = "" + CreditCards.bisectionMonthlyAmount(320000, .2);
        System.out.println(result);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 29157.1);
        b |= result.equals("" + 29157.08);
        assertTrue(b);
    }

    @Test
    public void testBisectionMonthlyAmount02() {
        String expResult = "" + 90325.03;
        String result = "" + CreditCards.bisectionMonthlyAmount(999999, .18);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 90325.02);
        b |= result.equals("" + 90325.04);
        assertTrue(b);
    }

    @Test
    public void testBisectionMonthlyAmount03() {
        String expResult = "" + 4071.15;
        String result = "" + CreditCards.bisectionMonthlyAmount(44681, .2);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 4071.14);
        b |= result.equals("" + 4071.16);
        assertTrue(b);
    }

    @Test
    public void testBisectionMonthlyAmount04() {
        String expResult = "" + 25196.65;
        String result = "" + CreditCards.bisectionMonthlyAmount(282651, .15);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 25196.64);
        b |= result.equals("" + 25196.66);
        assertTrue(b);
    }

    @Test
    public void testBisectionMonthlyAmount05() {
        String expResult = "" + 26486.38;
        String result = "" + CreditCards.bisectionMonthlyAmount(297119, .15);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 26486.37);
        b |= result.equals("" + 26486.39);
        assertTrue(b);
    }

    @Test
    public void testBisectionMonthlyAmount06() {
        String expResult = "" + 26507.0;
        String result = "" + CreditCards.bisectionMonthlyAmount(289655, .21);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 26506.99);
        b |= result.equals("" + 26507.01);
        assertTrue(b);
    }

    @Test
    public void testBisectionMonthlyAmount07() {
        String expResult = "" + 8893.5;
        String result = "" + CreditCards.bisectionMonthlyAmount(98461, .18);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 8893.49);
        b |= result.equals("" + 8893.51);
        assertTrue(b);
    }

    @Test
    public void testBisectionMonthlyAmount08() {
        String expResult = "" + 34421.99;
        String result = "" + CreditCards.bisectionMonthlyAmount(374521, .22);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 34421.98);
        b |= result.equals("" + 34422.00);
        assertTrue(b);
    }

    @Test
    public void testBisectionMonthlyAmount09() {
        String expResult = "" + 17044.7;
        String result = "" + CreditCards.bisectionMonthlyAmount(191204, .15);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 17044.69);
        b |= result.equals("" + 17044.71);
        assertTrue(b);
    }

    @Test
    public void testBisectionMonthlyAmount10() {
        String expResult = "" + 31355.69;
        String result = "" + CreditCards.bisectionMonthlyAmount(351742, .15);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 31355.68);
        b |= result.equals("" + 31355.70);
        assertTrue(b);
    }

    @Test
    public void testBisectionMonthlyAmount11() {
        String expResult = "" + 25076.06;
        String result = "" + CreditCards.bisectionMonthlyAmount(277620, .18);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 25076.05);
        b |= result.equals("" + 25076.07);
        assertTrue(b);
    }

    @Test
    public void testBisectionMonthlyAmount12() {
        String expResult = "" + 44360.55;
        String result = "" + CreditCards.bisectionMonthlyAmount(497628, .15);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 44360.54);
        b |= result.equals("" + 44360.56);
        assertTrue(b);
    }
}
