/**
 * The MergeSort class provides an implementation of the classic Merge Sort algorithm.
 * It follows the Divide and Conquer paradigm to sort an array of integers in ascending order.
 * 
 * Time Complexity: O(n log n) in all cases (best, worst, and average).
 * Space Complexity: O(n) auxiliary space due to the temporary sub-arrays.
 
 @Author: RAJVENKADAM S
 */
public class MergeSort {

    /**
     * Merges two sorted subarrays of arr[].
     * The first subarray is arr[left..mid].
     * The second subarray is arr[mid+1..right].
     *
     * @param arr   The main array containing the segments to be merged.
     * @param left  The starting index of the first subarray.
     * @param mid   The ending index of the first subarray.
     * @param right The ending index of the second subarray.
     */
    public static void Merge(int[] arr, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }
        
        // Initial indexes of first and second subarrays
        int i = 0;
        int j = 0;
        
        // Initial index of merged subarray
        int k = left;
        
        // Merge the temporary arrays back into arr[left..right]
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) { // Changed < to <= to maintain sorting stability
                arr[k] = L[i];
                i++;
            } else {
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
     * The main function that implements MergeSort by recursively splitting 
     * the array and calling the Merge function.
     *
     * @param arr   The array to be sorted.
     * @param left  The starting index of the segment to sort.
     * @param right The ending index of the segment to sort.
     */
    public static void MergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point to divide the array into two halves
            // (left + right) / 2 is avoided to prevent overflow for large bounds
            int mid = left + (right - left) / 2;
            
            // Sort first and second halves
            MergeSort(arr, left, mid);
            MergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            Merge(arr, left, mid, right);
        }
    }

    /**
     * Main method to test and demonstrate the functionality of the MergeSort implementation.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 1, 0, 9, 6};
        int left = 0;
        int right = arr.length - 1;
        
        System.out.println("Original Array:");
        printArray(arr);
        
        // Execute Merge Sort
        MergeSort(arr, left, right);
        
        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    /**
     * Helper utility function to print the elements of an array.
     *
     * @param arr The array to print.
     */
    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
