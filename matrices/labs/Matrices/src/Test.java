import static java.lang.System.out;

public class Test {

    private static int[][] squareMat = {{3,1,7},

            {8,7,3},

            {6,4,2}};



    public static void fun()

    {

        for(int r=0; r<squareMat.length; r++)

            for(int c=0; c<squareMat[r].length/2; c++)

                squareMat[r][c]=squareMat[c][r];

    }





//test code in another method of the same class
public static void main(String[] args) {

    fun();

    out.println(squareMat[1][0]);}   //line 1
}
