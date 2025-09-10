//© A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class SpiralMatrix
{
	//define a matrix
	int[][] spiralMat;

	public SpiralMatrix()
	{
		spiralMat= new int[1][1];
	}

	public SpiralMatrix(int size)
	{
		spiralMat = new int[size][size];
	}
	
	public void setSize(int size)
	{
		spiralMat = new int[size][size];
	}

	public void createSpiral()
	{
		int N = spiralMat.length;
		int num = 1;
		int top = 0;
		int bot = N - 1;
		int left = 0;
		int right = N - 1;

		while (num <= N * N) {
			for (int i = top; i <= bot; i++) {
				spiralMat[i][left] = num++;
			}
			left++;

			for (int i = left; i <= right; i++) {
				spiralMat[bot][i] = num++;
			}
			bot--;

			if (left <= right) {
				for (int i = bot; i >= top; i--) {
					spiralMat[i][right] = num++;
				}
				right--;
			}

			if (top <= bot) {
				for (int i = right; i >= left; i--) {
					spiralMat[top][i] = num++;
				}
				top++;
			}
		}
	}

	@Override
	public String toString() {
		String output = "";
		for (int[] row : spiralMat) {
			for (int num : row) {
				output += String.format("%-8d", num);
			}
			output+="\n";
		}
		return output;
	}
}