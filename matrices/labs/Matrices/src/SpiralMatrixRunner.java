//© A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SpiralMatrixRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("D:\\CS2K\\matrices\\labs\\Matrices\\src\\spiralMatrix.dat"));
		while (file.hasNextInt()){
			int N = file.nextInt();
			SpiralMatrix sm = new SpiralMatrix(N);
			sm.createSpiral();
			System.out.println(sm);
			System.out.println();
		}
	}
}