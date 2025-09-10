//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -  
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{
		mat = new char[3][3];
		for (int i = 0; i < 3; i++){
			Arrays.fill(mat[i], '-');
		}
	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
		char[] vals = game.toCharArray();
		int index = 0;
		for (int i = 0; i < 3; i++){
			for (int j  = 0; j < 3; j++){
				mat[i][j] = vals[index++];
			}
		}
	}

	public String getWinner()
	{
		for (char[] c : mat){
			if (c[0] == c[1] && c[1] == c[2]) return String.format("%c wins horizontally!\n\n", c[0]);
		}
		for (int i = 0; i < 3; i++){
			if (mat[0][i] == mat[1][i] && mat[1][i] == mat[2][i]) return String.format("%c wins vertically!\n\n", mat[0][i]);
		}
		if (mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2]) return String.format("%c wins diagonally!\n\n", mat[0][0]);
		if (mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0]) return String.format("%c wins diagonally!\n\n", mat[2][0]);
		return "cat's game - no winner\n\n";
	}

	public String toString()
	{
		String output="";
		for (char[] c : mat){
			for (int j = 0; j < 3; j++){
				output += c[j] + " ";
			}
			output+="\n";
		}
		return output.trim();
	}
}