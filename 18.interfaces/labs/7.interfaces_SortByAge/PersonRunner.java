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

public class PersonRunner
{
	public static void main ( String[] args ) throws IOException
	{
	   Scanner file = new Scanner(new File("D:\\CS2K\\18.interfaces\\labs\\7.interfaces_SortByAge\\person.dat"));
	   int N = file.nextInt();
	   ArrayList<Person> people = new ArrayList<>();
	   while (N-- > 0){
		   int year = file.nextInt();
		   int month = file.nextInt();
		   int day = file.nextInt();
		   String name = file.next();
		   people.add(new Person(year, month, day, name));
	   }
	   people.sort(Comparator.comparingInt(Person::getMyYear).thenComparingInt(Person::getMyMonth).thenComparingInt(Person::getMyDay).thenComparing(Person::getMyName));
	   //people.sort(Comparator.comparing((Person::getMyYear)).thenComparing(Person::getMyMonth).thenComparing(Person::getMyDay).thenComparing(Person::getMyName));
	   people.reversed().forEach(System.out::println);
	}
}