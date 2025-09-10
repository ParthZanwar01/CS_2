//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Words
{
	private ArrayList<Word> words;

	public Words()
	{
		setWords("");
		words = new ArrayList<>();
	}

	public Words(String wordList)
	{
		String[] wL = wordList.replaceAll(",", "").split(" ");
		words = new ArrayList<>();
		for (String s : wL) {
			words.add(new Word(s));
		}
	}

	public void setWords(String wordList)
	{
		words.clear();
		String[] wL = wordList.split(" ");
		for (String s : wL) {
			words.add(new Word(s));
		}
	}
	
	public int countWordsWithXChars(int size)
	{
		int count=0;
		for (Word w : words){
			if (w.getLength() == size) count++;
		}
		return count;
	}
	
	//this method will remove all words with a specified size / length
	//this method will also return the sum of the vowels in all words removed
	public int removeWordsWithXChars(int size)
	{
		int sum = 0;
		for (int i = 0; i < words.size(); i++){
			if (words.get(i).getLength() == size){
				sum+=words.get(i).getNumVowels();
				words.remove(i--);
			}
		}
		return sum;
	}

	public int countWordsWithXVowels(int numVowels)
	{
		int count=0;
		for (Word w : words){
			if (w.getNumVowels()==numVowels) count++;
		}
		return count;
	}
	
	public String toString()
	{
		String ret = "[";
		for (int i = 0; i < words.size()-1; i++){
			ret += words.get(i).toString() + ", ";
		}
		ret+=words.get(words.size()-1) + "]";
	    return ret;
	}
}