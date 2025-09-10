import java.util.Arrays;

public class Hard8 {
    public static void main(String[] args) {
        int[]ary = {8, 5, 8, 77, 12, 8};
        shift8s(ary);
        System.out.println(Arrays.toString(ary));

        ary = new int[]{9, 8, 8, 6, 3, 8, 4, 2, 1};
        shift8s(ary);
        System.out.println(Arrays.toString(ary));

        ary = new int[]{-13, -7, 8, 8, 4, 8, 8};
        shift8s(ary);
        System.out.println(Arrays.toString(ary));
    }

    public static void shift8s(int[] ary){
        for (int i = 1; i < ary.length; ++i){
            int key = ary[i];
            int j = i-1;

            while (j >= 0 && ary[j] != 8 && key == 8){
                ary[j+1] = ary[j];
                j = j-1;
            }
            ary[j+1] = key;
        }
    }
}
