//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;

public class Word2 implements Comparable<Word2>
{
	private String word;

	public Word2( String s)
	{
		word = s;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for (char c : word.toCharArray()){
			if (vowels.contains("" + c)) vowelCount++;
		}
		return vowelCount;
	}

	public int compareTo(Word2 rhs)
	{
		if (this.numVowels() < rhs.numVowels()) return -1;
		if (this.numVowels() > rhs.numVowels()) return 1;
		return word.compareToIgnoreCase(rhs.getWord());
	}

	public String toString()
	{
		return word;
	}
}