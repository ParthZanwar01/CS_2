//© A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class MagicSquare1Runner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("D:\\CS2K\\matrices\\labs\\Matrices\\src\\magic1.dat"));
		int N = file.nextInt();
		while (N-- > 0){
			int n = file.nextInt();
			file.nextLine();
			String s = file.nextLine();
			MagicSquare1 m1 = new MagicSquare1(n, s);
			out.println(m1);
		}
	}
}