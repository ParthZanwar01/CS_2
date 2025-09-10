//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToeRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("F:\\CS2K\\matrices\\labs\\Matrices\\src\\tictactoe.dat"));
		int N = file.nextInt();
		while (N-- > 0){
			String game = file.next();
			TicTacToe t = new TicTacToe(game);
			out.println(t);
			out.println(t.getWinner());
		}
	}
}