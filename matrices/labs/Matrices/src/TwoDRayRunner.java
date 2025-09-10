//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class TwoDRayRunner
{
	public static void main( String args[] )
	{
		ArrayList< TwoDRay> arr = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		out.print("How many matrices do you wish to enter? ");
		int N = in.nextInt();
		int count = 0;
		out.println("\n\n");
		while(N-- > 0){
			out.printf("What is the size of matrix %d : ", count);
			int size = in.nextInt();
			out.println();
			int[] matrix = new int[size*size];
			int index = 0;
			for (int i = 0; i < size; i++){
				for (int j = 0; j < size; j++){

				}
			}
		}
	}
}