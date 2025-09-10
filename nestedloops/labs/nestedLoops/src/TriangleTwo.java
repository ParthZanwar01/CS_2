//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/21/2024
//Class - CSK 2
//Lab  - TriangleTwo

import static java.lang.System.*;

public class TriangleTwo
{
   private int size;
   private String letter;

	public TriangleTwo()
	{
		size = 3;
		letter = "A";
	}

	public TriangleTwo( String let, int sz)
	{
		this.size = sz;
		this.letter = let;
	}

	public void setTriangle(int count, String let)
	{
		this.size = count;
		this.letter = let;
	}

	public String getLetter()
	{
		return letter;
	}

	public String toString()
	{
		String output="";
		for (int i = 0; i < size; i++){
			for (int j = size-i; j > 0; j--){
				output+= letter;
			}
			output+="\n";
		}
		return output;
	}
}