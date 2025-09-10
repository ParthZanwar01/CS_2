
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PartATest {
    
     /**
     * Test of minMonthlyPayment method, of class CreditCards.
     */
    @Test
    public void testMinMonthlyPayment() {
        double expResult = 31.38;
        double result = CreditCards.minMonthlyPayment(42, .2, .04);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testMinMonthlyPayment2() {
        double expResult = 361.61;
        double result = CreditCards.minMonthlyPayment(484, .2, .04);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testMinMonthlyPayment3() {
        double expResult = 87.63;
        double result = CreditCards.minMonthlyPayment(151, .2, .06);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testMinMonthlyPayment4() {
        double expResult = 181.11;
        double result = CreditCards.minMonthlyPayment(412, .18, .08);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testMinMonthlyPayment5() {
        double expResult = 236.71;
        double result = CreditCards.minMonthlyPayment(416, .18, .06);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testMinMonthlyPayment6() {
        double expResult = 305.82;
        double result = CreditCards.minMonthlyPayment(430, .15, .04);
        assertEquals(expResult, result, 0.0);
    }
}
