//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		word = s;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public int compareTo(Word rhs )
	{
		if (word.length() > rhs.getWord().length()) return 1;
		if (word.length() < rhs.getWord().length()) return -1;
		return word.compareToIgnoreCase(rhs.getWord());
	}

	public String toString()
	{
		return word;
	}
}