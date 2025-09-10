//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("D:\\CS2K\\18.interfaces\\labs\\4.interfaces_SortByLength_lab_java_aplus\\words.dat"));

		int size = file.nextInt();
		ArrayList<Word> words = new ArrayList<>();
		while (size-- > 0){
			String s = file.next();
			Word word = new Word(s);
			words.add(word);
		}
		Collections.sort(words);
		for (Word w : words){
			out.println(w.getWord());
		}

		











	}
}