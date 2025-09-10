package labs.recursion_counter;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.util.Random;

import static java.lang.System.*;

public class AtCounter
{
   //private String[][] atMat;

	private String[][] atMat = new String[][]{
			{"@", "-", "@", "-", "-", "@", "-", "@", "@", "@"},
			{"@", "@", "@", "-", "@", "@", "-", "@", "-", "@"},
			{"-", "-", "-", "-", "-", "-", "-", "@", "@", "@"},
			{"-", "@", "@", "@", "@", "@", "-", "@", "-", "@"},
			{"-", "@", "-", "@", "-", "@", "-", "@", "-", "@"},
			{"@", "@", "@", "@", "@", "@", "-", "@", "@", "@"},
			{"-", "@", "-", "@", "-", "@", "-", "-", "-", "@"},
			{"-", "@", "@", "@", "-", "@", "-", "-", "-", "-"},
			{"-", "@", "-", "@", "-", "@", "-", "@", "@", "@"},
			{"-", "@", "@", "@", "@", "@", "-", "@", "@", "@"},};

	public AtCounter()
	{
		/*
		atMat = new String[10][10];
		for (int i = 0; i < atMat.length; i++){
			for (int j = 0; j < atMat[i].length; j++){
				atMat[i][j] = (Math.round(Math.random())) == 0 ? "-" : "@";
			}
		}

		*/

	}

	public int countAts(int r, int c)
	{
		//add in recursive code to count up the # of @s connected
		//start checking at spot [r,c]
		int count = 0;
		if (inBounds(r, c) && atMat[r][c].equals("-")) return 0;
		if (inBounds(r, c) && atMat[r][c].equals("@")){
			count+=1;
			atMat[r][c] = "gayLivesMatter";
			count += countAts(r+1, c);
			count += countAts(r-1, c);
			count += countAts(r, c+1);
			count += countAts(r, c-1);

		}
		return count;
	}



	public boolean inBounds(int r, int c){
		return r >= 0 && r < atMat.length && c >= 0 && c < atMat[0].length;
	}

	/*
	 *this method will return all values in the matrix
	 *this method should return a view of the matrix
	 *that looks like a matrix
	 */
	public String toString()
	{
		String ret = "";
		for (String[] strings : atMat){
			for (String s : strings){
				ret += s + " ";
			}
			ret += "\n";
		}
		return ret;
	}
}