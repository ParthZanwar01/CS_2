//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/21/2024
//Class - CSK 2
//Lab  - TriangleThree

import static java.lang.System.*;

public class TriangleThree
{
   private int size;
   private String letter;

	public TriangleThree()
	{
		size = 3;
		letter = "A";
	}

	public TriangleThree(int count, String let)
	{
		this.size = count;
		this.letter = let;
	}

	public void setTriangle( String let, int sz )
	{
		this.size = sz;
		this.letter = let;
	}

	public String getLetter() 
	{
		return letter;
	}

	public String toString()
	{
		String output="";
		for (int i = 1; i <= size; i++){
			for (int j = 0; j < size-i; j++){
				output+= " ";
			}
			for (int k = 0; k < i; k++){
				output+= letter;
			}
			output+="\n";
		}
		return output;
	}
}