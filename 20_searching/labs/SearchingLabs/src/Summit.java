public class Summit {
    public static int mountainSummit(int[] arr) {
        return mountainSummit(arr, 0, arr.length-1);
    }

    public static int mountainSummit(int[] arr, int left, int right){
        if (left <= right){
            int mid = left + (right-left)/2;
            if (arr[mid-1] < arr[mid] && arr[mid+1] < arr[mid]) return mid;
            else if (arr[mid-1] < arr[mid] && arr[mid+1] > arr[mid]) return mountainSummit(arr, mid+1, right);
            else return mountainSummit(arr, left, mid-1);
        }
        return -(left+1);
    }

    public static void main(String[] args) {
        System.out.println(mountainSummit(new int[]{-1, 5, -1}));
        System.out.println(mountainSummit(new int[]{-1, 0, 8, 7, 6, 5, -1}));
        System.out.println(mountainSummit(new int[]{-1, 10, 8, 7, 6, 5, -1}));
        System.out.println(mountainSummit(new int[]{-1, 10, 18, 19, 26, 35, 34}));
        System.out.println(mountainSummit(new int[]{-1, 0, 3, 4, 5, 6, 8, 20, 30, 40, 50, 900, 10, 8, 7, 6, 5, -1}));
        System.out.println(mountainSummit(new int[]{-1, 0, 3, 4, 5, 6, 8, 20, 30, 40, 50, 90, 10, 8, 7, 6, 5, -1, -2, -3, -4, -5, -6}));

        int[]ary = new int[800_000_000];
        for (int i = 0; i < 687_500_000; i++) {
            ary[i] = Integer.MIN_VALUE + i;
        }
        for (int i = 687_500_000; i < ary.length; i++) {
            ary[i] = Integer.MAX_VALUE - i;
        }
        System.out.println(mountainSummit(ary));
        for (int i = 0; i < ary.length; i++) {
            ary[i] = Integer.MIN_VALUE + i;
        }
        ary[ary.length - 1] = Integer.MIN_VALUE;
        System.out.println(mountainSummit(ary));
    }
}
