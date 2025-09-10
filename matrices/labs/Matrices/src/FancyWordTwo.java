//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWordTwo
{
	private String[][] mat;

   public FancyWordTwo(String s)
	{
		mat = new String[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++){
			mat[0][i] = ""+s.charAt(i);
		}

		for (int k = 1, i = 1, j = s.length()-2; k < s.length(); k++, i++, j--){
			mat[k][0] = ""+s.charAt(i);
			mat[k][s.length()-1] = ""+s.charAt(j);
		}

		StringBuffer ss = new StringBuffer(s).reverse();
		for (int i = 0; i < s.length(); i++){
			mat[s.length()-1][i] = ""+ss.charAt(i);
		}


	}

	public String toString()
	{
		String output="";
		for (String[] s : mat){
			for (String ss : s){
				if (ss == null){
					output+=" ";
				}
				else output+=ss;
			}
			output+="\n";
		}

		return output+"\n\n";
	}
}