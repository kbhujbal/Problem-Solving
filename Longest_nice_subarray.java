import java.util.Scanner;

public class Longest_nice_subarray {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, bitMask = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            while ((bitMask & nums[right]) != 0) {
                bitMask ^= nums[left]; 
                left++; 
            }
            bitMask |= nums[right]; 
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Longest_nice_subarray solution = new Longest_nice_subarray();
        int result = solution.longestNiceSubarray(nums);

        System.out.println("Longest Nice Subarray Length: " + result);

        scanner.close();
    }
}
