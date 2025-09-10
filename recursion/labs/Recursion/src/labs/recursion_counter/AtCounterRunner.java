package labs.recursion_counter;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;

public class AtCounterRunner
{
	public static void main(String args[])
	{
		//instantiate an labs.recursion_counter.AtCounter
		AtCounter at = new AtCounter();

		//out.println(at);
		out.println("0 0 has " + at.countAts(0, 0) +  " @s connected");
		out.println("2 5 has " + at.countAts(2, 5)  +  " @s connected");
		out.println("5 0 has " + at.countAts(5, 0) +  " @s connected");
		out.println("9 9 has " + at.countAts(9, 9)  +  " @s connected");
		out.println("3 9 has " + at.countAts(3, 9)  +  " @s connected");

		//test the code
	}
}