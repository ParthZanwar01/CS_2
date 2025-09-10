//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/29/24
//Class - CSK2
//Lab  - BlockTestOne

import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

public class blockTestOne {

	@Test(timeout = 200)
	public void testToString1() {
		Block one = new Block();
		String res = "100 1500 10 10 java.awt.Color[r=0,g=0,b=0]";
		assertEquals(res, one.toString());
	}


	@Test(timeout = 200)
	public void testToString2() {
		Block two = new Block(50, 50, 30, 30);
		String res = "50 50 30 30 java.awt.Color[r=0,g=0,b=0]";
		assertEquals(res, two.toString());
	}


	@Test(timeout = 200)
	public void testToString3() {
		Block three = new Block(350, 350, 15, 15, Color.red);
		String res = "350 350 15 15 java.awt.Color[r=255,g=0,b=0]";
		assertEquals(res, three.toString());
	}


	@Test(timeout = 200)
	public void testToString4() {
		Block four = new Block(450, 50, 20, 60, Color.green);
		String res = "450 50 20 60 java.awt.Color[r=0,g=255,b=0]";
		assertEquals(res, four.toString());
	}


	@Test(timeout = 200)
	public void testGetX1() {
		Block four = new Block(450, 50, 20, 60, Color.green);
		int res = 450;
		assertEquals(res, four.getX());
	}


	@Test(timeout = 200)
	public void testGetY() {
		Block four = new Block(450, 50, 20, 60, Color.green);
		int res = 50;
		assertEquals(res, four.getY());
	}


	@Test(timeout = 200)
	public void testGetX2() {
		Block four = new Block();
		int res = 100;
		assertEquals(res, four.getX());
	}


	@Test(timeout = 200)
	public void testGetY2() {
		Block four = new Block();
		int res = 1500;
		assertEquals(res, four.getY());
	}


	@Test(timeout = 200)
	public void testGetWidth1() {
		Block four = new Block();
		int res = 10;
		assertEquals(res, four.getWidth());
	}


	@Test(timeout = 200)
	public void testGetWidth2() {
		Block four = new Block(30, 30, 57, 40);
		int res = 57;
		assertEquals(res, four.getWidth());
	}


	@Test(timeout = 200)
	public void testGetHeight1() {
		Block four = new Block();
		int res = 10;
		assertEquals(res, four.getHeight());
	}


	@Test(timeout = 200)
	public void testGetHeight2() {
		Block four = new Block(30, 30, 486, 50);
		int res = 50;
		assertEquals(res, four.getHeight());
	}


	@Test(timeout = 200)
	public void testGetColor1() {
		Block four = new Block();
		assertEquals(Color.BLACK, four.getColor());
	}


	@Test(timeout = 200)
	public void testGetColor2() {
		Block four = new Block(20, 36, 40, 56, Color.cyan);
		assertEquals(Color.cyan, four.getColor());
	}


	@Test(timeout = 200)
	public void testSetX1() {
		Block four = new Block();
		four.setX(151);
		int res = 151;
		assertEquals(res, four.getX());
	}


	@Test(timeout = 200)
	public void testSetX2() {
		Block four = new Block();
		four.setX(13678);
		int res = 13678;
		assertEquals(res, four.getX());
	}


	@Test(timeout = 200)
	public void testSetY1() {
		Block four = new Block();
		four.setY(151);
		int res = 151;
		assertEquals(res, four.getY());
	}


	@Test(timeout = 200)
	public void testSetY2() {
		Block four = new Block();
		four.setY(212);
		int res = 212;
		assertEquals(res, four.getY());
	}


	@Test(timeout = 200)
	public void testSetWidth1() {
		Block four = new Block();
		four.setWidth(151);
		int res = 151;
		assertEquals(res, four.getWidth());
	}


	@Test(timeout = 200)
	public void testSetWidth2() {
		Block four = new Block();
		four.setWidth(212);
		int res = 212;
		assertEquals(res, four.getWidth());
	}


	@Test(timeout = 200)
	public void testSetHeight1() {
		Block four = new Block();
		four.setHeight(151);
		int res = 151;
		assertEquals(res, four.getHeight());
	}


	@Test(timeout = 200)
	public void testSetHeight2() {
		Block four = new Block();
		four.setHeight(212);
		int res = 212;
		assertEquals(res, four.getHeight());
	}


	@Test(timeout = 200)
	public void testSetColor() {
		Block b = new Block();
		Color c = new Color(215, 252, 212);
		b.setColor(c);
		assertEquals(c, b.getColor());
	}


	@Test(timeout = 200)
	public void testSetColor2() {
		Block b = new Block(20, 20, 50, 60, new Color(67, 90, 69));
		Color c = new Color(67, 90, 69);
		assertEquals(c, b.getColor());
	}


	@Test(timeout = 200)
	public void testContains() {
		Block b = new Block(2, 5, 8, 10);
		assertTrue(b.contains(2, 5));
		assertFalse(b.contains(0, 0));
	}


	@Test(timeout = 200)
	public void testContains2() {
		Block b = new Block(14, 9, 3, 3);
		assertTrue(b.contains(15, 11));
		assertFalse(b.contains(14, 7));
	}


	@Test(timeout = 200)
	public void testContains3() {
		Block b = new Block(10, 10, 1, 1);
		assertTrue(b.contains(11, 10));
		assertFalse(b.contains(10, 9));
	}


	@Test(timeout = 200)
	public void testCanonicalize() {
		Block b = new Block(10, 10, 3, -4);
		b.canonicalize();
		Block res = new Block(10, 6, 3, 4);
		assertEquals(b.getX(), res.getX());
		assertEquals(b.getY(), res.getY());
		assertEquals(b.getWidth(), res.getWidth());
		assertEquals(b.getHeight(), res.getHeight());


	}


	@Test(timeout = 200)
	public void testUnion1() {
		Block b = new Block();
		Block b2 = new Block();
		Block ret = b.union(b2);
		Block b3 = new Block();
		assertEquals(ret.toString(), b3.toString());
	}


	@Test(timeout = 200)
	public void testUnion2() {
		Block block1 = new Block(10, 10, 50, 50);
		Block block2 = new Block(20, 20, 100, 100);
		Block ret = block1.union(block2);
		assertEquals(ret.toString(), new Block(10, 10, 110, 110).toString());
	}


	@Test(timeout = 200)
	public void testUnion3() {
		Block block1 = new Block(151, 163, 55, 56);
		Block block2 = new Block(20, 20, 100, 100);
		Block ret = block1.union(block2);
		assertEquals(ret.toString(), new Block(20, 20, 186, 199).toString());
	}


	@Test(timeout = 200)
	public void testIntersection1() {
		Block block1 = new Block(10, 10, 50, 50);
		Block block2 = new Block(20, 20, 100, 100);
		Block ret = block1.intersection(block2);
		assertEquals(new Block(20, 20, 40, 40).toString(), ret.toString());
	}


	@Test(timeout = 200)
	public void testIntersection2() {
		Block block1 = new Block();
		Block block2 = new Block();
		Block ret = block1.intersection(block2);
		assertEquals(ret.toString(), new Block().toString());
	}
}