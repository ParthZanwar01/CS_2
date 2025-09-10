//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Monster
{
	private String name;
	private int howBig;

	private int pos;

	public Monster()
	{
		name = "Tom";
		howBig = 1;
	}

	public Monster(String n, int size, int pos)
	{
		name = n;
		howBig = size;
		this.pos = pos;
	}

	public String getName()
	{
		return name;
	}
	
	public int getHowBig()
	{
		return howBig;
	}
	
	public boolean isBigger(Monster other)
	{
		return this.howBig > other.howBig;
	}
	
	public boolean isSmaller(Monster other)
	{
		return !isBigger(other);
	}

	public boolean namesTheSame(Monster other)
	{
		return this.name.equalsIgnoreCase(other.name);
	}
	
	public String toString()
	{
		return "Monster " + pos + " - " + name + " " + howBig;
	}
}