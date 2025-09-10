//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class MatrixSummingRunner
{
	public static void main( String args[]) throws IOException
	{
		Scanner file = new Scanner(new File("F:\\CS2K\\matrices\\labs\\Matrices\\src\\matsum.dat"));
		int N = file.nextInt();
		MatrixSumming m = new MatrixSumming();
		while (N-- > 0){
			int r = file.nextInt(), c = file.nextInt();
			out.printf("The sum of %d, %d is %d.\n",r, c, m.sum(r, c));
		}
	}
}



