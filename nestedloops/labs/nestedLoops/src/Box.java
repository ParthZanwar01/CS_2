//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/21/24
//Class - CSK 2
//Lab  - Box

import static java.lang.System.*;

public class Box
{
   private int size;

	public Box()
	{
		this.size= 3;
	}

	public Box(int count)
	{
		this.size = count;
	}

	public void setSize(int count)
	{
		this.size = count;
	}

	public int getSize()
	{
		return size;
	}

	public String toString()
	{
		String output="";
		for (int i = 1; i <= size; i++){
			for (int j = size+1-i; j > 0; j--){
				output+="*";
			}
			for (int k = i; k > 0; k--){
				output+="#";
			}
			output+="\n";

		}
		return output;
	}
}