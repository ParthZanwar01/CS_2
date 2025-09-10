//© A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class MagicSquare1
{
	private int[][] a;

	//size the matrix and load in the numbers into the matrix
	//write all nested loop code here in the constructor
	public MagicSquare1(int size, String numbers)
	{
		Scanner sc = new Scanner(numbers);
		a = new int[size][size];
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				a[i][j] = sc.nextInt();
			}
		}
	}

	public boolean isMagicSquare(){

	if (a.length < 2) return true;
    int topL = a.length;
		for (int[] ints : a) {
			if (topL != ints.length) return false;
		}
    
    if (a.length != a[0].length) return false;
    int sum = 0;
    for (int i = 0; i < a.length; i++){
     sum += a[0][i];   
    }
    
    for (int j = 0; j < a.length; j++){
        int rSum = 0;
        int cSum = 0;
        for (int k = 0; k < a.length; k++){
            rSum += a[j][k];
            cSum += a[k][j];
        }
        if (sum != rSum || sum != cSum) return false;
    }
    
    int diag1 = 0;
    int diag2 = 0;
    for (int l = 0; l < a.length; l++){
     for (int m = 0; m < a.length; m++){
         if (l == m) diag1 += a[l][m];
     }
    }
		return diag1 == sum;
	}

	public int sumRow( int r )
	{
		return 0;
	}

	public int sumCol( int c )
	{
		return 0;
	}

	public int sumDownDiag()
	{
		return 0;
	}

	public int sumUpDiag()
	{
		return 0;
	}

	public String toString()
	{
		String output="";
		for (int[] i : a){
			for (int s : i){
				output+=s + " ";
			}
			output+="\n";
		}
		if (isMagicSquare()) output += "MAGIC SQUARE";
		else output += "NOT A MAGIC SQUARE";
		return output + "\n\n";
	}
}