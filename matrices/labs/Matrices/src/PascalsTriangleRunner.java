//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class PascalsTriangleRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("F:\\CS2K\\matrices\\labs\\Matrices\\src\\pascalTriangle.dat"));
		int N = file.nextInt();
		while (N-- > 0){
			int size = file.nextInt();
			PascalsTriangle pt = new PascalsTriangle(size);
			pt.createTriangle();
			out.println(pt);
		}
	}
}



