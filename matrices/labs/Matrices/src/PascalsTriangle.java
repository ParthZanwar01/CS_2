//© A+ Computer Science  -  www.apluscompsci.com
//Name - Partn Zanwar
//Date - 10/12/24
//Class - AP Comp Sci
//Lab  - PascalsTriangle

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class PascalsTriangle
{
	private int[][] mat;

	public PascalsTriangle()
	{
		mat = new int[1][1];

		for (int i = 0; i < mat.length; i++){
			Arrays.fill(mat[i], 0);
		}
	}

	public PascalsTriangle(int size)
	{
		mat = new int[size][size];

	}

	public void createTriangle()
	{
		mat[0][0] = 1;
		if (mat.length > 1) {
			mat[1][0] = 1;
			mat[1][1] = 1;
		}
		for (int i = 2; i < mat.length; i++){
			mat[i][0] = 1;
			for (int j = 1; j < mat[i].length; j++){
				mat[i][j] = mat[i-1][j-1]+mat[i-1][j];
			}
		}




	}

	public String toString()
	{
		String output="";
		for (int i = 0; i < mat.length; i++){
			for (int j = 0; j < mat[0].length; j++){
				if (mat[i][j] == 0) continue;
				output += String.format("%-8d", mat[i][j]);
			}
			output += "\n";
		}
		return output + "\n\n";
	}
}