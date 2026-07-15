import java.util.Scanner;

/**
 * The LinearSearch class provides an interactive command-line interface 
 * to find the index of a target element in an array using Sequential Search.
 * 
 * Works on both sorted and unsorted data arrays.
 * Time Complexity: 
 *   - Best Case: O(1) (Target is the very first element checked)
 *   - Worst/Average Case: O(n) (Target is at the end or not present)
 * Space Complexity: O(1) - Auxiliary Space (Constant extra memory)
 * 
 * @author RAJVENKADAM S
 */
public class LinearSearch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // 1. Prompt user for array size
        System.out.print("Enter the number of elements: ");
        int range = scan.nextInt();
        
        // 2. Initialize array and prompt for inputs
        int[] nums = new int[range];
        System.out.println("Enter " + range + " integers (can be completely unsorted):");
        for (int i = 0; i < range; i++) {
            nums[i] = scan.nextInt();
        }
        
        // 3. Prompt user for the target element to locate
        System.out.print("Enter the target element to search for: ");
        int target = scan.nextInt();
        
        // 4. Linear Search Logic
        int resultIndex = -1; // -1 means target not found by default
        
        for (int i = 0; i < range; i++) {
            if (nums[i] == target) {
                resultIndex = i; // Record the index where the match occurred
                break;           // Target found, break out of the loop early
            }
        }
        
        // 5. Output the result
        if (resultIndex != -1) {
            System.out.println("Success: Target " + target + " found at index " + resultIndex + ".");
        } else {
            System.out.println("Result: Target " + target + " was not found in the array.");
        }
        
        // Close resources to prevent potential memory leaks
        scan.close();
    }
}
