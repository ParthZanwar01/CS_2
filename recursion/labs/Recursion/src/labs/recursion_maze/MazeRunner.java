package labs.recursion_maze;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class MazeRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("maze.dat"));
		while (file.hasNextLine()){
			int N = file.nextInt();
			file.nextLine();
			String arr = file.nextLine();
			Maze maze = new Maze(N, arr);
			out.print(maze);
			out.println(maze.hasExitPath(0, 0) ? "exit found\n" : "exit not found\n");
		}
	}
}