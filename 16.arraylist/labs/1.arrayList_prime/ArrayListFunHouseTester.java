import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


import static org.junit.Assert.*;


public class ArrayListFunHouseTester {


    @Test(timeout = 200)
    public void test1() {
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(1);
        ret.add(3);
        assertEquals(ret, ArrayListFunHouse.getListOfFactors(9));
    }

    @Test(timeout = 200)
    public void test2() {
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(1);
        assertEquals(ret, ArrayListFunHouse.getListOfFactors(23));
    }

    @Test(timeout = 200)
    public void test3() {
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(1);
        ret.add(2);
        ret.add(5);
        ret.add(10);
        ret.add(25);
        assertEquals(ret, ArrayListFunHouse.getListOfFactors(50));
    }

    @Test(timeout = 200)
    public void test4() {
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(1);
        ret.add(2);
        ret.add(4);
        ret.add(5);
        ret.add(10);
        ret.add(20);
        ret.add(25);
        ret.add(50);
        assertEquals(ret, ArrayListFunHouse.getListOfFactors(100));
    }

    @Test(timeout = 200)
    public void test5() {
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(1);
        ret.add(2);
        ret.add(3);
        ret.add(6);
        ret.add(127);
        ret.add(254);
        ret.add(381);
        assertEquals(ret, ArrayListFunHouse.getListOfFactors(762));
    }
}
