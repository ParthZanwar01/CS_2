import java.util.Random;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -
public class Grid
{
   private String[][] grid;

   //load vals into the rows x cols grid randomly
	public Grid(int rows, int cols, String[] vals)
	{
        Random r = new Random();
		r.setSeed(1);
        grid = new String[rows][cols];
        for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				grid[i][j] = vals[r.nextInt(vals.length)];
			}
		}
	}

	//find out which of the vals occurs the most
	public String findMax(String[] vals)
	{
		int maxCount = 0;
		String val = "";
		for (String s : vals){
			int tempCount = countVals(s);
			if (tempCount > maxCount){
				maxCount = tempCount;
				val = s;
			}
		}
		return val;
	}

	//returns a count of how many times val occurs in the matrix
	public int countVals( String val )
	{
		int count = 0;
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				if (val.equals(grid[i][j])) count++;
			}
		}
		return count;
	}

	//display the grid
	public String toString()
	{
		String output="";
        for (String[] strings : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                output += strings[j] + " ";
            }
            output += "\n";
        }
		

		return output;
	}
}

