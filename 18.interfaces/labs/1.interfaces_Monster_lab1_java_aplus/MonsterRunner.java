//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		int n = 3;
		while (n-- > 0){
			out.print("Enter 1st monster's name : ");
			String name1 = keyboard.next();
			out.print("Enter 1st monster's size  : ");
			int size1 = keyboard.nextInt();
			out.print("Enter 2nd monster's name : ");
			String name2 = keyboard.next();
			out.print("Enter 2nd monster's size  : ");
			int size2 = keyboard.nextInt();
			Monster m1 = new Monster(name1, size1, 1);
			Monster m2 = new Monster(name2, size2, 2);
			out.println(m1);
			out.println(m2);
			out.println();
			out.println(m1.isBigger(m2) ? "Monster one is bigger than Monster two." : "Monster one is smaller than Monster two.");
			out.println(m1.namesTheSame(m2) ? "Monster one has the same name as Monster two.\n\n" : "Monster one does not have the same name as Monster two.\n\n");
		}
	}
}