//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GridRunner
{
	public static void main( String args[] ) throws IOException
	{
		String[] arr = {"a","b","c", "7", "9","x","2"};
		Grid g = new Grid(20, 20, arr);
		System.out.println(g);
		for (String s : arr){
			out.printf("%s count is %d\n",s, g.countVals(s));
		}
		out.println();
		System.out.println(g.findMax(arr) + " occurs the most");
	}
}