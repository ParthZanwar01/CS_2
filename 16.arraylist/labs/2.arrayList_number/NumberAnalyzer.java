//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public class NumberAnalyzer
{
	private ArrayList<Number> list;

	public NumberAnalyzer()
	{
		list = new ArrayList<>();
	}

	public NumberAnalyzer(String numbers)
	{
		list = new ArrayList<>();
		for (int i = 0; i < numbers.split(" ").length; i++){
			list.add(new Number(Integer.parseInt(numbers.split(" ")[i])));
		}
	}
	
	public void setList(String numbers)
	{
		list.clear();
		list = new ArrayList<>();
		for (int i = 0; i < numbers.split(" ").length; i++){
			list.add(new Number(Integer.parseInt(numbers.split(" ")[i])));
		}
	}

	public int countOdds()
	{
      int oddCount=0;
		for (Number number : list) {
			if (number.isOdd()) oddCount++;
		}
      return oddCount;
	}

	public int countEvens()
	{
      int evenCount=0;
		for (Number number : list) {
			if (!number.isOdd()) evenCount++;
		}
      return evenCount;
	}

	public int countPerfects()
	{
		int perfectCount=0;
		for (Number number : list) {
			if (number.isPerfect()) perfectCount++;
		}
      return perfectCount;
	}
	
	public String toString( )
	{
		String ret = "[";
		for (int i = 0; i < list.size()-1; i++){
			ret+=list.get(i) + ", ";
		}
		ret+=list.get(list.size()-1) + "]";
		return ret;
	}
}