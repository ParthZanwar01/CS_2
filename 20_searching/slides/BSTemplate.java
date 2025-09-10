public class BSTemplates {

    // this is a standard template for an iterative binary search
    // this is what CollegeBoard will use on the AP exam
    public static int binarySearch(int[] ary, int target) {
        if (ary == null || ary.length == 0)
            return -1;

        int low = 0, high = ary.length - 1;
        while (low <= high) {
            // required to prevent overflow if low + high > Integer.MAX_VALUE
            // otherwise (low + high) / 2 will work
            int mid = low + (high - low) / 2;
            if (ary[mid] == target) {
                return mid;
            } else if (ary[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // not found
        return -1;
    }

    // this is a slightly modified version of the binarySearch algorithm which compares the middle element to it's neighbor
    // to the right. Use that condition to divide the search space in half. This loop stops when there is one element
    // remaining which requires a post-processing check. Note this code could be further modified to exit and leave
    // two remaining elements to check by altering the loop to while(left + 1 < right). The problem will dictate which
    // variety to use.
    public static int binarySearchAlt(int[] ary, int target) {
        if (ary == null || ary.length == 0)
            return -1;

        int left = 0, right = ary.length - 1;
        while (left < right) {
            // required to prevent overflow if low + high > Integer.MAX_VALUE
            // otherwise (low + high) / 2 will work
            int mid = left + (right - left) / 2;
            if (ary[mid] == target) {
                return mid;
            } else if (ary[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left != ary.length && ary[left] == target) return left;
        return -1;
    }

    // uses bisection search to calculate the square root of a number rounded down to the nearest integer
    public static int sqrt(int x) {
        if(x <= 1) return x;

        int left = 0, right = x / 2 + 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
}
