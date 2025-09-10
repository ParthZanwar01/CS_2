import java.util.*;
import java.io.*; 

public class MatrixSumming
{
    private int[][] m;

    public MatrixSumming(){
        m = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 0},
                {6, 7, 1, 2, 5},
                {6, 7, 8, 9, 0},
                {5, 4, 3, 2, 1}
        };
    }

    public int sum( int r, int c )
    {
    	int sum = 0;
        int[] indexes = new int[]{-1, 0, 1};
        for (int i : indexes){
            for (int j : indexes){
                if (isValid(r+i, c+j)){
                    sum += m[r+i][c+j];
                }
            }
        }
        return sum;
    }

    public boolean isValid(int r, int c){
        return (r >= 0 && r < m.length) && (c >= 0 && c < m[0].length);
    }


    public String toString()
    {
    	return "";
    }
}
