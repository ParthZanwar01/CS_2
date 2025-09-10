//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class SiteNameRunner
{
	public static void main ( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("D:\\CS2K\\18.interfaces\\labs\\8.interfaces_WebsiteSorter\\sitename.dat"));
		int N = file.nextInt();
		ArrayList<SiteName> sites = new ArrayList<>();
		while (N-- > 0){
			String filename = file.next();
			sites.add(new SiteName(filename));
		}
		Collections.sort(sites);
		sites.forEach(System.out::println);
	}
}
