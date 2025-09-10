//© A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class ThreeDRayRunner
{
	public static void main( String args[] )
	{
   	Scanner keyboard = new Scanner(in);

		out.print("How many matrices do you wish to enter? :: ");
		int matCnt = keyboard.nextInt();

		//instantiate a ThreeDRay
		ThreeDRay matrices = new ThreeDRay(matCnt);

		for(int i = 0; i < matCnt; i++)
		{
			out.print("What is the size of matrix " + i + " : ");
			int size = keyboard.nextInt();

			int[][] mat = new int[size][size];
			out.println();
			for(int r=0; r<mat.length; r++)
			{
				for(int c=0; c<mat[r].length; c++)
				{
					out.print("Enter a value for spot " + r + " - " + c + " :: ");
				   mat[r][c]=keyboard.nextInt();
				}
			}

		    out.println("\nThreeDRay before setting mat at spot "+i);
			out.println(matrices);

			//call setMatrix
			matrices.setMatrix(i, mat);

			out.println("\nThreeDRay after setting mat at spot "+i);
			//print out the ThreeDRay - call toString()
			out.println(matrices);

			//call setMatrix
		}

		out.println("\nAdding matrix at 0 and matrix at 1");
		int[][] ans = matrices.addMatrices(0, 1);
		for(int[] row : ans)
		{
			for(int c : row)
			{
				out.print(c + " ");
			}
			out.println();
		}

		out.println("Multiplying matrix at 0 and matrix at 1");
		int[][] mul = matrices.multiplyMatrices(0, 1);
		for(int[] row : mul)
		{
			for(int c : row)
			{
				out.print(c + " ");
			}
			out.println();
		}
	}
}