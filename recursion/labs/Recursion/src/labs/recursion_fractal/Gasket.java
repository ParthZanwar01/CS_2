package labs.recursion_fractal;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;
import java.util.Random;

public class
Gasket extends Canvas implements Runnable
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final Random rand = new Random();

	public Gasket()
	{
		setBackground(Color.WHITE);
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.BLUE);
		window.setFont(new Font("ARIAL",Font.BOLD,24));
		window.drawString("Sierpinski's Gasket", 25, 50);

		gasket(window, (WIDTH-10)/2, 20, WIDTH-40, HEIGHT-20, 40, HEIGHT-20);
	}

	public void gasket(Graphics window, int x1, int y1, int x2, int y2, int x3, int y3)
	{
		if (distance(x1, y1, x2, y2) > 30) {
			window.setColor(Color.WHITE);
		} else window.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));

		// Draw filled triangle
		int[] xPoints = { x1, x2, x3 };
		int[] yPoints = { y1, y2, y3 };
		window.fillPolygon(xPoints, yPoints, 3);

		// Recursive case
		if (Math.abs(x3 - x1) > 10) {
			// Calculate midpoints
			int xD = (x1 + x2) / 2;
			int yD = (y1 + y2) / 2;
			int xE = (x2 + x3) / 2;
			int yE = (y2 + y3) / 2;
			int xF = (x3 + x1) / 2;
			int yF = (y3 + y1) / 2;

			// Recursive calls for each of the inner triangles
			gasket(window, x1, y1, xD, yD, xF, yF);
			gasket(window, xD, yD, x2, y2, xE, yE);
			gasket(window, xF, yF, xE, yE, x3, y3);
		}
	}

	private double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	public void run()
	{
		try{
		  	Thread.currentThread().sleep(3);
		}
		catch(Exception e)
		{
		}
	}
}