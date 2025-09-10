//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  - 

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;

	private String ret;
	
	public MadLib()
	{
		verbs = new ArrayList<>();
		nouns = new ArrayList<>();
		adjectives = new ArrayList<>();
		loadNouns();
		loadVerbs();
		loadAdjectives();
		ret = "";
	}

	public MadLib(String fileName)
	{
		verbs = new ArrayList<>();
		nouns = new ArrayList<>();
		adjectives = new ArrayList<>();
		loadNouns();
		loadVerbs();
		loadAdjectives();
		ret = "";
		try{
			Scanner file = new Scanner(new File("story.dat"));
			while (file.hasNext()){
				String next = file.next();
				if (next.equals("#")){
					ret+=getRandomNoun()+ " ";
					continue;
				}
				if (next.equals("@")){
					ret+=getRandomVerb() + " ";
					continue;
				}
				if (next.equals("&")){
					ret += getRandomAdjective() + " ";
					continue;
				} else {
					ret += next + " ";
				}
			}
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
			e.printStackTrace();
		}
		
	}

	public void loadNouns()
	{
		try{
			Scanner file = new Scanner(new File("nouns.dat"));
			while (file.hasNext()){
				nouns.add(file.next());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}
	
	public void loadVerbs()
	{
		try{
			Scanner file = new Scanner(new File("verbs.dat"));
			while (file.hasNext()){
				verbs.add(file.next());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void loadAdjectives()
	{
		try{
			Scanner file = new Scanner(new File("adjectives.dat"));
			while (file.hasNext()){
				adjectives.add(file.next());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public String getRandomVerb()
	{
		int max = verbs.size()-1;
		int min = 0;
		int range = max-min+1;
		int rand = (int)(Math.random() * range) + min;
		return verbs.get(rand);
	}
	
	public String getRandomNoun()
	{
		int max = nouns.size()-1;
		int min = 0;
		int range = max-min+1;
		int rand = (int)(Math.random() * range) + min;
		return nouns.get(rand);
	}
	
	public String getRandomAdjective()
	{
		int max = adjectives.size()-1;
		int min = 0;
		int range = max-min+1;
		int rand = (int)(Math.random() * range) + min;
		return adjectives.get(rand);
	}		

	public String toString()
	{
	   return ret;
	}
}