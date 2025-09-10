package labs.recursion_maze;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;

	public Maze(int size, String line)
	{
		maze = new int[size][size];
		Scanner sc = new Scanner(line);
		for (int i  = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				maze[i][j] = sc.nextInt();
			}
		}
	}

	public boolean hasExitPath(int r, int c)
	{
		if (c==maze.length-1 && maze[r][c] ==  1) return true;
		if (maze[r][c] == 0) return false;
		if (inBounds(r, c) && maze[r][c] == 1) {
			maze[r][c] = 2;
			if (inBounds(r - 1, c) && hasExitPath(r - 1, c)) return true;
			if (inBounds(r + 1, c) && hasExitPath(r + 1, c)) return true;
			if (inBounds(r, c + 1) && hasExitPath(r, c + 1)) return true;
			if (inBounds(r, c - 1) && hasExitPath(r, c - 1)) return true;
		}
		return false;
	}

	public boolean inBounds(int r, int c){
		return r >= 0 && r < maze.length && c >= 0  && c < maze.length;
	}

	public String toString()
	{
		String output="";
		for (int[] ints : maze){
			for (int i : ints){
				output+= i + " ";
			}
			output += "\n";
		}
		return output;
	}
}