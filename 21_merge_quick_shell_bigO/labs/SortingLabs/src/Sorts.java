import java.util.*;

/**
 *
 * @author Parth Zanwar
 */
public class Sorts {

    /**
     * Canonical Bubble Sort that repeatedly swaps adjacent pairs that are 
     * non-increasing until no swaps are performed on a given pass. Runs
     * in 0(N^2) unless the array is sorted for the best case of O(N).
     * @param arr of integers
     */
    public static void bubbleSort(int[] arr){
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }

    /**
     * Classical insertion sort algorithm that runs in 0(N^2) unless the array
     * is sorted in which the best case is O(N). Conceptually the algorithm is
     * similar to sorting a hand of cards as the dealer deals each card. Each
     * time you pick up a card you shift all cards over that are less than that
     * card then insert the new card in the appropriate location. Hence the name
     * insertion sort.
     *
     * @param arr of integers
     */
    public static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * For each index, find the smallest element and perform one swap. Runs in
     * 0(N^2) for all cases but performs at most N-1 swaps.
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {

            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {

                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }

    /**
     * Divide and Conquer algorithm that picks a pivot and moves all elements
     * that are less than the pivot to the left side and similarly all elements
     * larger than the pivot to the right. Repeat the process on both sides. The
     * algorithm is linearithmic O(nlogn) but can degenerate if a poorly chosen
     * pivot is selected. Choose a randomized pivot to help prevent this. The 
     * algorithm is quite fast as the name suggests, takes advantage of cache hits 
     * but it is not stable(no impact on ints).
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length-1);
    }

    private static void quickSortRecursive(int[] arr, int left, int right) {
        if (left < right) {

            // pi is the partition return index of pivot
            int pi = pivot(arr, left, right);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSortRecursive(arr, left, pi - 1);
            quickSortRecursive(arr, pi + 1, right);
        }
    }

    private static int pivot(int[] arr, int left, int right) {
        int pivot = arr[right];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = left - 1;

        // Traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, right);
        return i + 1;
    }

    /**
     * Divide and conquer algorithm that repeatedly divides the array into
     * halves then merges the halves together. The algorithm is stable and runs
     * in O(nlogn) in all cases. It's an out of place algorithm since a temporary
     * array is used in the merge method.
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        mergeSortRecursive(arr, 0, arr.length-1);
    }

    private static void mergeSortRecursive(int[] arr, int begin, int end) {
        if (begin < end) {

            // Find the middle point
            int m = begin + (end - begin) / 2;

            // Sort first and second halves
            mergeSortRecursive(arr, begin, m);
            mergeSortRecursive(arr, m + 1, end);

            // Merge the sorted halves
            merge(arr, begin, m, end);
        }
    }

    // merge two portions that are sorted respectively by creating an auxilliary
    // array as a place holder then copy it back
    private static void merge(int[] arr, int start, int middle, int end) {
        int n1 = middle - start + 1;
        int n2 = end - middle;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[start + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[middle + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = start;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Shell sort algorithm Shell sort begins by picking an arbitrary collection
     * of gap values. For each gap value K, K calls are made to the insertion
     * sort variant function to sort K interleaved lists. Shell sort ends with a
     * final gap value of 1, to finish with the regular insertion sort. A common
     * option is to choose powers of 2 minus 1, in descending order. Ex: For an
     * array of size 100, gap values would be 63, 31, 15, 7, 3, and 1. This gap
     * selection technique results in Shellsort's time complexity being no worse
     * than O(N^3/2). You may choose any gap sequence that you like.
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {

    }


    /**
     * Classical bogo sort algorithm that runs in 0(N!) unless the array
     * is sorted in which the best case is O(N). Conceptually the algorithm is
     * similar to shuffling a deck of cards then checking if it's sorted.
     *
     * @param arr of integers
     */
    public static void bogoSort(int[] arr) {
        //todo
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
