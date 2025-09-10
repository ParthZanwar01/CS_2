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

public class Word2Runner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner in = new Scanner(new File("D:\\CS2K\\18.interfaces\\labs\\5.interfaces_SortByVowels_lab_java_aplus\\word2.dat"));
		int size = in.nextInt();
		ArrayList<Word2> words = new ArrayList<>();
		while (size-- > 0){
			String s = in.next();
			Word2 word = new Word2(s);
			words.add(word);
		}
		Collections.sort(words);
		for (Word2 w : words){
			out.println(w.getWord());
		}

	}
}