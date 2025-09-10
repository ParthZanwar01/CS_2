//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class - 
//Lab  -

import java.util.Arrays;
import java.util.Objects;

public class ThreeDRay
{
	private int[][][] matrices;

	//add constructors
	public ThreeDRay(int size){
		matrices = new int[size][][];
	}

	public void setMatrixSize(int whichMat, int rowsize, int colSize)
	{
		matrices[whichMat] = new int[rowsize][colSize];
	}

	public void setMatrix(int whichMat, int[][] mat)
	{
		matrices[whichMat] = mat;
	}

	public int[][] getMatrix(int whichMat)
	{
		return matrices[whichMat];
	}

	public int[][] addMatrices(int one, int two )
	{
		int[][] result = new int[matrices[one].length][matrices[one].length];
		for (int i = 0; i < result.length; i++){
			for (int j = 0; j < result[0].length; j++){
				result[i][j] = matrices[one][i][j] + matrices[two][i][j];
			}
		}
		return result;
	}

	public int[][] multiplyMatrices(int one, int two){
		int[][] result = new int[matrices[one].length][matrices[two][0].length];
		for (int i = 0; i < result.length; i++){
			for (int j = 0; j < result[0].length; j++){
				for (int k = 0; k < matrices[two].length; k++){
					result[i][j] += matrices[one][i][k] * matrices[two][k][j];
				}
			}
		}
		return result;
	}

	public String toString()
	{
		String output="";
		for (int i = 0; i < matrices.length; i++){
			output += "mat " + i + "\n";
			if (Arrays.deepEquals(matrices[i], null)){
				continue;
			}
			else{
				output+="\n";
				for (int k = 0; k < matrices[i].length; k++){
					output += " ".repeat(8) + "row " + k + " ".repeat(4);
					for (int j = 0; j < matrices[i][k].length; j++){
						output += matrices[i][k][j] + " ";
					}
					output+="\n";
				}
			}
		}





		return output;
	}
}