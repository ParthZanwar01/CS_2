//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/22/24
//Class - CSK 2
//Lab  - ColoredBoxes

import java.awt.*;

class ColoredBoxes extends Canvas
{
	public ColoredBoxes()
	{
		setBackground(Color.WHITE);
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.RED);
		window.setFont(new Font("TAHOMA",Font.BOLD,12));
	  	window.drawString("Graphics Lab Lab11g ", 20, 40 );
	  	window.drawString("Drawing boxes with nested loops ", 20, 80 );

	  	drawBoxes(window);
	}

	public void drawBoxes(Graphics window)
	{
		window.setColor(Color.BLUE);
		for (int i = 100; i <= 300; i+=25){
			for (int j = 100; j <= 300; j+=25) {
				window.fillRect(j, i, 20, 20);

			}

		}
	}
}