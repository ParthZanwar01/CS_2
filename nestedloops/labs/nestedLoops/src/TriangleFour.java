//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class TriangleFour
{
   private int size;
   private String letter;

	public TriangleFour()
	{
		this.size = 3;
		this.letter = "R";
	}

	public TriangleFour(int count, String let)
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
		for (int i = 0; i < size; i++){
			for (int j = i; j > 0; j--){
				output+=" ";
			}
			for (int k = size-i; k > 0; k--){
				output+=letter;
			}
			output+="\n";
		}
		return output;
	}
}