
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PartBTest {
    /**
     * Test of minFixedMonthlyPayment method, of class CreditCards.
     */
    @Test
    public void testMinFixedMonthlyPayment() {
        int expResult = 310;
        int result = CreditCards.minFixedMonthlyPayment(3329, .2);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment02() {
        int expResult = 440;
        int result = CreditCards.minFixedMonthlyPayment(4773, .2);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment03() {
        int expResult = 360;
        int result = CreditCards.minFixedMonthlyPayment(3926, .2);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment04() {
        int expResult = 10;
        int result = CreditCards.minFixedMonthlyPayment(70, .25);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment05() {
        int expResult = 90;
        int result = CreditCards.minFixedMonthlyPayment(938, .2);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment06() {
        int expResult = 80;
        int result = CreditCards.minFixedMonthlyPayment(793, .2);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment07() {
        int expResult = 80;
        int result = CreditCards.minFixedMonthlyPayment(835, .18);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment08() {
        int expResult = 430;
        int result = CreditCards.minFixedMonthlyPayment(4778, .15);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment09() {
        int expResult = 390;
        int result = CreditCards.minFixedMonthlyPayment(4510, .04);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment10() {
        int expResult = 420;
        int result = CreditCards.minFixedMonthlyPayment(4919, .04);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment11() {
        int expResult = 330;
        int result = CreditCards.minFixedMonthlyPayment(3603, .18);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment12() {
        int expResult = 440;
        int result = CreditCards.minFixedMonthlyPayment(4800, .2);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment13() {
        int expResult = 370;
        int result = CreditCards.minFixedMonthlyPayment(4053, .15);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment14() {
        int expResult = 360;
        int result = CreditCards.minFixedMonthlyPayment(4019, .15);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinFixedMonthlyPayment15() {
        int expResult = 330;
        int result = CreditCards.minFixedMonthlyPayment(3618, .15);
        assertEquals(expResult, result);
    }
}
