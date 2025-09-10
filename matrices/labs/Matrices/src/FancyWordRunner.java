//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class FancyWordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File ("F:\\CS2K\\matrices\\labs\\Matrices\\src\\fancyword.dat"));
		int size = file.nextInt();
		while (size-- > 0){
			String word = file.next();
			FancyWord f = new FancyWord(word);
			out.println(f);
		}
	}
}