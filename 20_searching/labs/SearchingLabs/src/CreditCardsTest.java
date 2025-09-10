
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class CreditCardsTest {

    /**
     * Test of minMonthlyPayment method, of class CreditCards.
     */
    @Test(timeout=5)
    public void testMinMonthlyPayment() {
        double expResult = 31.38;
        double result = CreditCards.minMonthlyPayment(42, .2, .04);
        assertEquals(expResult, result, 0.0);
    }

    @Test(timeout=5)
    public void testMinMonthlyPayment2() {
        double expResult = 361.61;
        double result = CreditCards.minMonthlyPayment(484, .2, .04);
        assertEquals(expResult, result, 0.0);
    }

    @Test(timeout=5)
    public void testMinMonthlyPayment3() {
        double expResult = 87.63;
        double result = CreditCards.minMonthlyPayment(151, .2, .06);
        assertEquals(expResult, result, 0.0);
    }

    @Test(timeout=5)
    public void testMinMonthlyPayment4() {
        double expResult = 181.11;
        double result = CreditCards.minMonthlyPayment(412, .18, .08);
        assertEquals(expResult, result, 0.0);
    }

    @Test(timeout=5)
    public void testMinMonthlyPayment5() {
        double expResult = 236.71;
        double result = CreditCards.minMonthlyPayment(416, .18, .06);
        assertEquals(expResult, result, 0.0);
    }

    @Test(timeout=5)
    public void testMinMonthlyPayment6() {
        double expResult = 305.82;
        double result = CreditCards.minMonthlyPayment(430, .15, .04);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of minFixedMonthlyPayment method, of class CreditCards.
     */
    @Test(timeout=5)
    public void testMinFixedMonthlyPayment() {
        int expResult = 310;
        int result = CreditCards.minFixedMonthlyPayment(3329, .2);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment02() {
        int expResult = 440;
        int result = CreditCards.minFixedMonthlyPayment(4773, .2);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment03() {
        int expResult = 360;
        int result = CreditCards.minFixedMonthlyPayment(3926, .2);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment04() {
        int expResult = 10;
        int result = CreditCards.minFixedMonthlyPayment(70, .25);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment05() {
        int expResult = 90;
        int result = CreditCards.minFixedMonthlyPayment(938, .2);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment06() {
        int expResult = 80;
        int result = CreditCards.minFixedMonthlyPayment(793, .2);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment07() {
        int expResult = 80;
        int result = CreditCards.minFixedMonthlyPayment(835, .18);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment08() {
        int expResult = 430;
        int result = CreditCards.minFixedMonthlyPayment(4778, .15);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment09() {
        int expResult = 390;
        int result = CreditCards.minFixedMonthlyPayment(4510, .04);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment10() {
        int expResult = 420;
        int result = CreditCards.minFixedMonthlyPayment(4919, .04);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment11() {
        int expResult = 330;
        int result = CreditCards.minFixedMonthlyPayment(3603, .18);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment12() {
        int expResult = 440;
        int result = CreditCards.minFixedMonthlyPayment(4800, .2);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment13() {
        int expResult = 370;
        int result = CreditCards.minFixedMonthlyPayment(4053, .15);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment14() {
        int expResult = 360;
        int result = CreditCards.minFixedMonthlyPayment(4019, .15);
        assertEquals(expResult, result);
    }

    @Test(timeout=5)
    public void testMinFixedMonthlyPayment15() {
        int expResult = 330;
        int result = CreditCards.minFixedMonthlyPayment(3618, .15);
        assertEquals(expResult, result);
    }

    /**
     * Test of bisectionMonthlyAmount method, of class CreditCards.
     */
    @Test(timeout=5)
    public void testBisectionMonthlyAmount() {
        String expResult = "" + 29157.09;
        String result = "" + CreditCards.bisectionMonthlyAmount(320000, .2);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 29157.1);
        b |= result.equals("" + 29157.08);
        assertTrue(b);
    }

    @Test(timeout = 5)
    public void testBisectionMonthlyAmount02() {
        String expResult = "" + 90325.03;
        String result = "" + CreditCards.bisectionMonthlyAmount(999999, .18);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 90325.02);
        b |= result.equals("" + 90325.04);
        assertTrue(b);
    }

    @Test(timeout=5)
    public void testBisectionMonthlyAmount03() {
        String expResult = "" + 4071.15;
        String result = "" + CreditCards.bisectionMonthlyAmount(44681, .2);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 4071.14);
        b |= result.equals("" + 4071.16);
        assertTrue(b);
    }

    @Test(timeout=5)
    public void testBisectionMonthlyAmount04() {
        String expResult = "" + 25196.65;
        String result = "" + CreditCards.bisectionMonthlyAmount(282651, .15);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 25196.64);
        b |= result.equals("" + 25196.66);
        assertTrue(b);
    }

    @Test(timeout=5)
    public void testBisectionMonthlyAmount05() {
        String expResult = "" + 26486.38;
        String result = "" + CreditCards.bisectionMonthlyAmount(297119, .15);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 26486.37);
        b |= result.equals("" + 26486.39);
        assertTrue(b);
    }

    @Test(timeout=5)
    public void testBisectionMonthlyAmount06() {
        String expResult = "" + 26507.0;
        String result = "" + CreditCards.bisectionMonthlyAmount(289655, .21);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 26506.99);
        b |= result.equals("" + 26507.01);
        assertTrue(b);
    }

    @Test(timeout=5)
    public void testBisectionMonthlyAmount07() {
        String expResult = "" + 8893.5;
        String result = "" + CreditCards.bisectionMonthlyAmount(98461, .18);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 8893.49);
        b |= result.equals("" + 8893.51);
        assertTrue(b);
    }

    @Test(timeout=5)
    public void testBisectionMonthlyAmount08() {
        String expResult = "" + 34421.99;
        String result = "" + CreditCards.bisectionMonthlyAmount(374521, .22);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 34421.98);
        b |= result.equals("" + 34422.0);
        assertTrue(b);
    }

    @Test(timeout=5)
    public void testBisectionMonthlyAmount09() {
        String expResult = "" + 17044.7;
        String result = "" + CreditCards.bisectionMonthlyAmount(191204, .15);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 17044.69);
        b |= result.equals("" + 17044.71);
        assertTrue(b);
    }

    @Test(timeout=5)
    public void testBisectionMonthlyAmount10() {
        String expResult = "" + 31355.69;
        String result = "" + CreditCards.bisectionMonthlyAmount(351742, .15);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 31355.68);
        b |= result.equals("" + 31355.70);
        assertTrue(b);
    }

    @Test(timeout=5)
    public void testBisectionMonthlyAmount11() {
        String expResult = "" + 25076.06;
        String result = "" + CreditCards.bisectionMonthlyAmount(277620, .18);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 25076.05);
        b |= result.equals("" + 25076.07);
        assertTrue(b);
    }

    @Test(timeout=5)
    public void testBisectionMonthlyAmount12() {
        String expResult = "" + 44360.55;
        String result = "" + CreditCards.bisectionMonthlyAmount(497628, .15);
        boolean b = result.equals(expResult);
        b |= result.equals("" + 44360.54);
        b |= result.equals("" + 44360.56);
        assertTrue(b);
    }
}
