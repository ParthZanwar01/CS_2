import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] ary, int target) {
        return binarySearch(ary, target, 0, ary.length-1);
    }

    public static int binarySearch(int[] ary, int target, int left, int right){
        if (left <= right) {
            int mid = left + (right-left)/2;
            if (ary[mid] == target) return mid;
            else if (ary[mid] > target) return binarySearch(ary, target, left, mid - 1);
            else if (ary[mid] < target) return binarySearch(ary, target, mid + 1, right);
        }
        return -(left+1);
    }

    public static void main(String[] args) {


        int[] arr = {-100, -89, -78, -67, -55, -33, 20, -1, 0, 1, 2, 22, 23, 24, 34, 55, 80, 90};
        boolean pass = true;
        for(int i = -102; i < 91 && pass; i++){
            if(binarySearch(arr, i) != Arrays.binarySearch(arr, i)){
                pass = false;
            }
        }
        System.out.println(pass ? "Code passes :)": "Code fails :(");

        // Depending on your computer the code below code take upwards of 10 minutes
        /*
        int[]ary = new int[200_000_000];
        for (int i = 1; i< ary.length; i++) {
            ary[i] = i * i * - 2 * i + 13;
        }
        Arrays.sort(ary);
        boolean passes = true;
        long start = System.currentTimeMillis();
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE && passes; i++) {
            if(binarySearch(ary, i) != Arrays.binarySearch(ary, i)){
                passes = false;
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println(passes ? "Code passes :)": "Code fails :(");
        System.out.println((stop - start)/ 1000);
         */
    }
}