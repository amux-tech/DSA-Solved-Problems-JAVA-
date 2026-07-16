package practice;

import java.util.Scanner;

/**
 * The QuickSort class provides an interactive command-line interface 
 * to sort an array of integers using the Quick Sort algorithm.
 * 
 * It implements the Lomuto Partition Scheme using a recursive approach.
 * Time Complexity: 
 *   - Best/Average Case: O(n log n) (When partitions are relatively balanced)
 *   - Worst Case: O(n^2) (When the array is already sorted or reversed)
 * Space Complexity: O(log n) average auxiliary space due to call stack frames (In-place sorting)
 * 
 * @author RAJVENKADAM S
 */
public class QuickSort {

	public static int Partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = (left - 1); // Index of smaller element

		for (int j = left; j < right; j++) {
			// If current element is smaller than or equal to pivot
			if (arr[j] >= pivot) {
				i++;

				// Swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// Swap the pivot element with the element at i + 1
		int temp = arr[i + 1];
		arr[i + 1] = arr[right];
		arr[right] = temp;

		return i + 1; // Return the partitioning index
	}

	public static void QuickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pi = Partition(arr, left, right);
			QuickSort(arr, left, pi - 1);
			QuickSort(arr, pi + 1, right);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 1. Prompt user for array size
		System.out.print("Enter the number of elements: ");
		int range = scan.nextInt();
		
		// 2. Initialize array and prompt for inputs
		int[] arr = new int[range];
		System.out.println("Enter " + range + " integers");
		for (int i = 0; i < range; i++) {
			arr[i] = scan.nextInt();
		}
		
		int left = 0;
		int right = arr.length - 1;
		
		// 3. Execute sorting strategy
		QuickSort(arr, left, right);

		// 4. Displaying sorted array in a clean format
		System.out.print("Sorted Array: ");
		for (int i = left; i <= right; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(); // Prints a clean new line at the end
		
		// Close resources to prevent potential memory leaks
		scan.close();
	}
}
