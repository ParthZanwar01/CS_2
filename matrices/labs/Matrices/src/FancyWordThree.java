//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWordThree
{
	private String[][] mat;

   public FancyWordThree(String s)
	{
		//size the matrix
		mat = new String[s.length()*s.length()+1][s.length()*s.length()+1];
		//use Arrays.fill() to fill in the matrix with spaces
		if (s.length()==1){
			mat[0][0] = s;
		}
		else {
			//use a for loop to load in the letters into the matrix
			String rev = new StringBuilder(s).reverse().toString();
			int index = 0;
			for (int i = 0; i < s.length(); i++) {
				mat[index][s.length() * 2 - 2 - i] = "" + rev.charAt(i);
				mat[index][s.length() * 2 - 2 + i] = "" + rev.charAt(i);
				index++;
			}
			int space = 1;
			for (int i = 1; i < s.length()-1; i++){
				int x = s.length()-i-1;
				mat[s.length()+i-1][x] = "" + s.charAt(i);
				mat[s.length()+i-1][x+space*2] = "" + s.charAt(i);
				mat[s.length()+i-1][x+s.length()-2+s.length()] = "" + s.charAt(i);
				mat[s.length()+i-1][x+s.length()-2+space*2+s.length()] = "" + s.charAt(i);
				space+=1;
				index++;
			}
			String s1 = "" + s.charAt(s.length() - 1);
			mat[index][0] = s1;
			mat[index][s.length()+s.length()-2] = s1;
			mat[index++][(s.length()+s.length()-2)*2] = s1;
			space = (s.length()-1);
			for (int i = s.length()-2; i > 0; i--){
				int x = s.length()-i-1;
				mat[index][x] = "" + s.charAt(i);
				mat[index][x+space*2-2] = "" + s.charAt(i);
				mat[index][x+s.length()-2+s.length()] = "" + s.charAt(i);
				mat[index][x+s.length()-4+space*2+s.length()] = "" + s.charAt(i);
				space-=1;
				index++;
			}

			space= 1;
			for (int i = s.length()-1; i > 0; i--) {
				mat[index][s.length() + space-2] = "" + rev.charAt(i);
				mat[index][s.length() * 2 - 2 + i] = "" + rev.charAt(i);
				index++;
				space++;
			}
			mat[index][s.length() * 2 - 2] = ""+s.charAt(0);

		}


	}

	public String toString()
	{
		String output="";
		for (String[] s : mat){
			for (String ss : s){
				if (ss == null) output+=" ";
				else output+=ss;
			}
			output+="\n";
		}
		return output+"\n\n";
	}
}