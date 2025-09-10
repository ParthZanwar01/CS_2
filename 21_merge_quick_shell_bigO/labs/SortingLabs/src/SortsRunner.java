
import java.util.*;

public class SortsRunner {

    public static int RANGE = 100_000;

    /**
     * Randomly fill up the given array with integers from +- RANGE(100,000 by default)
     */
    public static void fillArray(int[] arr) {
        Random randGen = new Random();
        for (int i = 0; i < arr.length; i++) {
            int val = randGen.nextInt(RANGE);
            arr[i] = randGen.nextBoolean() ? val : -val;
        }
    }

    /**
     * isSorted
     *
     * @return true if the array is sorted from least to largest or is sorted
     * from largest to least
     */
    public static boolean isSorted(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        int index = 0;
        while (index < arr.length - 1 && arr[index] == arr[index + 1]) {
            index++;
        }
        // bypass first equal elements
        if (index == arr.length - 1) {
            return true; // all elements are the same
        } else if (index < arr.length - 1 && arr[index] > arr[index + 1]) // possible descend
        {
            for (int i = index + 2; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) {
                    return false;
                }
            }
        } else // sort for ascend
        {
            for (int i = index + 2; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * test the sort with given array. The test array will be modified.
     *
     * @param a The array that is used to test the sort.
     * @name The name of sort method that is to be tested
     */
    public static void testSort(int[] a, String name) {
        long totalTime = 0;
        // get start time
        long start = Calendar.getInstance().getTimeInMillis();
        switch (name) {
            case "Bubble Sort":
                Sorts.bubbleSort(a);
                break;
            case "Insert Sort":
                Sorts.insertSort(a);
                break;
            case "Select Sort":
                Sorts.selectSort(a);
                break;
            case "Quick Sort":
                Sorts.quickSort(a);
                break;
            case "Merge Sort":
                Sorts.mergeSort(a);
                break;
            case "Shell Sort":
                Sorts.shellSort(a);
                break;
            case "Bogo Sort":
                Sorts.bogoSort(a);
                break;
            default:
                break;
        }

        long end = Calendar.getInstance().getTimeInMillis();
        if (isSorted(a)) {
            totalTime = end - start;
            System.out.println("Execution time for " + name + " is: " + totalTime + " milliseconds");
        } else {
            System.out.println("The " + name + " did not work properly");
        }
    }

    /**
     * display the test menu
     */
    public static void displayMenu() {
        System.out.println("****************************");
        System.out.println("*           MENU           *");
        System.out.println("*  0. Enter Array Size:    *");
        System.out.println("*  1. Shuffle Array        *");
        System.out.println("*  2. Bubble Sort          *");
        System.out.println("*  3. Select Sort          *");
        System.out.println("*  4. Insert Sort          *");
        System.out.println("*  5. Quick Sort           *");
        System.out.println("*  6. Merge Sort           *");
        System.out.println("*  7. Shell Sort           *");
        System.out.println("*  8. Bogo Sort            *");
        System.out.println("*  9. Quit                 *");
        System.out.println("* 10. Print out Array");
        System.out.println("****************************");
    }

    public static void main(String[] args) {
        int choice;
        int[] arr = new int[RANGE];
        fillArray(arr);

        Scanner input = new Scanner(System.in);
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 0: // set size
                    arr = new int[RANGE = input.nextInt()];
                    break;
                case 1: // generate a new random filled array
                    fillArray(arr);
                    break;
                case 2: // bubble sort
                    testSort(arr, "Bubble Sort");
                    break;
                case 3: // select sort
                    testSort(arr, "Select Sort");
                    break;
                case 4: // insert sort
                    testSort(arr, "Insert Sort");
                    break;
                case 5: // quick sort
                    testSort(arr, "Quick Sort");
                    break;
                case 6: // merge sort
                    testSort(arr, "Merge Sort");
                    break;
                case 7: // shell sort
                    testSort(arr, "Shell Sort");
                    break;
                case 8: // bogo sort
                    testSort(arr, "Bogo Sort");
                    break;
                case 9: // quit
                    System.out.println("Ciao!");
                    break;
                case 10:
                    
                default: // wrong choice
            }

        } while (choice != 9);
    }

}
