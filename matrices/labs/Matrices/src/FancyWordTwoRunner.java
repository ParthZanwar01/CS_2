//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class FancyWordTwoRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("D:\\CS2K\\matrices\\labs\\Matrices\\src\\fancyword.dat"));
		int N = file.nextInt();
		while (N-- > 0){
			FancyWordTwo f = new FancyWordTwo(file.next());
			out.println(f);
		}
	}
}