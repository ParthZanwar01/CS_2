//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Toy implements Comparable<Toy>
{
	private String name;
	private int count;

	public Toy()
	{
		name = "Pokemon cards";
		count = 1;
	}

	public Toy( String nm )
	{
		name = nm;
		String[] words = nm.split(" ");
		count = 1;
	}

	public Toy(String nm, int count){
		name = nm;
		this.count = count;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount( int cnt )
	{
		count = cnt;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName( String nm )
	{
		name = nm;
	}

	public String toString()
	{
	   return name + " " + count;
	}

	@Override
	public int compareTo(Toy o) {
		return Math.max(this.count, o.count);
	}
}