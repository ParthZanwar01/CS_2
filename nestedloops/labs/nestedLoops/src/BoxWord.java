//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/22/24
//Class - CSK 2
//Lab  - BoxWord

import static java.lang.System.*;

class BoxWord
{
   private String word;

	public BoxWord()
	{
		word="word";
	}

	public BoxWord(String s)
	{
		this.word = s;
	}

	public void setWord(String w)
	{
		this.word = w;
	}

	public String toString()
	{
		if (word.length() == 1) return word;
		String output=word+"\n";
		for (int i = 1, j = output.length()-3; i < word.length()-1; i++, j--){
			output += word.charAt(i) + " ".repeat(word.length()-2) + word.charAt(j) + "\n";
		}
		StringBuffer s = new StringBuffer(word).reverse();
		return output += s.toString();

	}
}