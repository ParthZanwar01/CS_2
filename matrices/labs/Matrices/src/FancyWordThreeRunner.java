//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.*;

public class FancyWordThreeRunner
{
	public static void main( String args[] ) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("F:\\CS2K\\matrices\\labs\\Matrices\\src\\fancyword3.dat"));
		int N = scanner.nextInt();
		while (N-- > 0){
			FancyWordThree fancyWordThree = new FancyWordThree(scanner.next());
			out.println(fancyWordThree);
		}

	}
}