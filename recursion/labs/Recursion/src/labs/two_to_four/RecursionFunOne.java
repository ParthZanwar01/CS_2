package labs.two_to_four;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;

public class RecursionFunOne
{
	public static int countOddDigits(int num)
	{
		if (num % 10 == num) return num%10%2;
		return countOddDigits(num/10) + num%10%2;
	}
}