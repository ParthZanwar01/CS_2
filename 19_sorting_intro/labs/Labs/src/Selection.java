import java.util.ArrayList;
import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[]ary = {-3, 5, 33, 77, 12, -22};
        selectionSort(ary);
        System.out.println(Arrays.toString(ary));

        ary = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        selectionSort(ary);
        System.out.println(Arrays.toString(ary));

        ary = new int[]{-13, -7, 3, 4, 4, 11, 13};
        selectionSort(ary);
        System.out.println(Arrays.toString(ary));
    }

    public static void selectionSort(int[] ary){
        for (int i  = 0; i < ary.length-1; i++){
            boolean isSorted = false;
            int minIdx = i;
            for (int j = i+1; j < ary.length; j++){
                if (ary[minIdx] > ary[j]){
                    isSorted = true;
                    minIdx = j;
                }
            }
            int temp = ary[minIdx];
            ary[minIdx] = ary[i];
            ary[i] = temp;
            if (!isSorted){
                break;
            }
        }
    }
}
