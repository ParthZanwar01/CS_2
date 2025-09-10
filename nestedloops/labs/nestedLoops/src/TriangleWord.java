//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/22/24
//Class - CSK 2
//Lab  - TriangleWord

import static java.lang.System.*;

class TriangleWord
{
   private String word;

	public TriangleWord()
	{
		word = "word";
	}

	public TriangleWord(String w)
	{
		this.word = w;
	}

	public void setWord(String w)
	{
		this.word = w;
	}

	public String toString()
	{
		if (word.length() == 1) return word;
		String output=" ".repeat(word.length()-1) + word.charAt(0)+ " ".repeat(word.length()-1) + "\n";
		for(int i = 1, j=1; i < word.length()-1; i++, j+=2){
			output+=" ".repeat(word.length()-1-i) + word.charAt(i) + " ".repeat(j) + word.charAt(i) + " ".repeat(word.length()-1-i) + "\n";
		}
		StringBuffer s = new StringBuffer(word).reverse();
		output += s + word.substring(1);
		return output;

	}
}