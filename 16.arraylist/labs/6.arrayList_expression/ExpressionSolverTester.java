import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ExpressionSolverTester {

    @Test(timeout = 200)
    public void test1() {
        ExpressionSolver t = new ExpressionSolver("3 + 5");
        t.solveExpression();
        assertEquals(t.toString(), "3 + 5 = 8");
    }

    @Test(timeout = 200)
    public void test2() {
        ExpressionSolver t = new ExpressionSolver("3 * 5");
        t.solveExpression();
        assertEquals(t.toString(), "3 * 5 = 15");
    }

    @Test(timeout = 200)
    public void test3() {
        ExpressionSolver t = new ExpressionSolver("3 - 5");
        t.solveExpression();
        assertEquals(t.toString(), "3 - 5 = -2");
    }

    @Test(timeout = 200)
    public void test4() {
        ExpressionSolver t = new ExpressionSolver("3 / 5");
        t.solveExpression();
        assertEquals(t.toString(), "3 / 5 = 0");
    }

    @Test(timeout = 200)
    public void test5() {
        ExpressionSolver t = new ExpressionSolver("5 / 5 * 2 + 8 / 2 + 5");
        t.solveExpression();
        assertEquals(t.toString(), "5 / 5 * 2 + 8 / 2 + 5 = 11");
    }

    @Test(timeout = 200)
    public void test6() {
        ExpressionSolver t = new ExpressionSolver("5 * 5 + 2 / 2 - 8 + 5 * 5 - 2");
        t.solveExpression();
        assertEquals(t.toString(), "5 * 5 + 2 / 2 - 8 + 5 * 5 - 2 = 41");
    }



}
