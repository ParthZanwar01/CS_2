//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth
//Date - 8/21/24
//Class - CSK 2
//Lab  - Triples

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		this.number = num;
	}

	public void setNum(int num)
	{
		this.number = num;
	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int gcfAB = gcf(a, b);
		return gcf(gcfAB, c);
	}

	public int gcf(int a, int b){
		if (b==0) return a;
		return gcf(b, a%b);
	}

	public String toString()
	{
		String output="";
		for (int a = 1; a < number; a++){
			for (int b = a+1; b < number; b++){
				for (int c = b+1; c < number; c++){
					int check = 0;
					if((a*a) + (b*b) == (c*c)) check++;
					if (a%2!=b%2 && c%2==1) check++;
					if (greatestCommonFactor(a, b, c) <= 1) check++;
					if (check == 3) output += a + " " + b + " " + c + "\n";
				}
			}
		}
		return output;
	}
}