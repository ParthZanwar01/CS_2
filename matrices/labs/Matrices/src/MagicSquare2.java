//© A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class MagicSquare2
{
	private int[][] mat;

	//size the matrix and make the magic square pattern
	//write all nested loop code here in the constructor
	public MagicSquare2(int size)
	{
		mat = new int[size][size];
		int num = 1;
		int row = 0;
		int col = size/2;
		while(num<=size*size){
			if (mat[row][col] == 0)
			{
				mat[row][col] = num;
				num++;
			}
			else
			{
				row += 2;
				col--;
				if (row >= size) row -= size;
				if (col < 0) col += size;
				continue;
			}
			row--;
			col++;
			if (row < 0) row += size;
			if (col >= size) col -= size;
		}
	}


	public String toString()
	{
		String output="";
		for (int[] i : mat){
			for (int j : i){
				output+= String.format("%-2d      ", j);
			}
			output+="\n";
		}
		return output+"\n\n";
	}
}