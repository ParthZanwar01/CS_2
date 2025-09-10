//© A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class MagicSquare2Runner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("F:\\CS2K\\matrices\\labs\\Matrices\\src\\magic2.dat"));
		while (file.hasNextInt()){
			MagicSquare2 m2 = new MagicSquare2(file.nextInt());
			out.println(m2);
		}
	}
}