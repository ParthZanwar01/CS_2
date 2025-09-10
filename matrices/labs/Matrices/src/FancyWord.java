//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord
{
	private String[][] mat;

   public FancyWord(String s)
	{
		//size the matrix
		mat = new String[s.length()][s.length()];

		for (int i = 0; i < mat.length; i++){
			Arrays.fill(mat[i], " ");
		}

		if (s.length() == 1){
			mat[0][0] = s;
		}
		if (s.length() == 2){
			mat[0][0] = ""+s.charAt(0);
			mat[0][1] = ""+s.charAt(1);
			mat[1][0] = ""+s.charAt(0);
			mat[1][1] = ""+s.charAt(1);
		}
		else {
			//use a for loop to load in the letters into the matrix
			for (int i = 0; i < s.length(); i++) {
				mat[0][i] = "" + s.charAt(i);
			}
			for (int i = 1; i < s.length() / 2 + 1; i++) {
				mat[i][i] = "" + s.charAt(i);
				mat[i][s.length() - i-1] = "" + s.charAt(s.length() - i - 1);
			}

			for (int j = s.length() / 2 + 1, i = s.length()/2-1; j < s.length(); j++, i--){
				mat[j][i] = "" + s.charAt(i);
				mat[j][s.length()-i-1] = "" + s.charAt(s.length()-i-1);
			}
			/*
			for (int i = 0; i < s.length(); i++) {
				mat[mat.length-1][i] = "" + s.charAt(i);
			}
			 */


		}
	}

	public String toString()
	{
		String output="";
		String word = "";
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (i == 0) word += mat[i][j];
				output += mat[i][j];
			}
			output += "\n";
		}
		output = output.trim();
		if (word.length()%2==1 && word.length() > 1) output = output.substring(0,output.lastIndexOf("\n"));
		if (word.length() <= 2) return output + "\n\n";
		return output+"\n"+word+"\n\n";
	}
}