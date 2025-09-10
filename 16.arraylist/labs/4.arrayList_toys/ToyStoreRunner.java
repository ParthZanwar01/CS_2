//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStoreRunner
{
	public static void main( String args[] ) {
		ToyStore ts = new ToyStore();
		ts.loadToys("sorry bat sorry sorry sorry train train teddy teddy ball ball");
		out.println(ts);
	}
}