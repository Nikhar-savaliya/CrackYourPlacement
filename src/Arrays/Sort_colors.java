package Arrays;

import java.util.Arrays;

public class Sort_colors {
    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bruteORbetter(int[] nums) {
        // use bucketsort to find number of 0's 1's and 2's and the override the nums
        // array.
    }

    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;

                left++;
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;

                right--;
                i--;
                /**
                 * ?? Why i-- ??
                 * => let nums = [0,1,2,1,0,2]
                 * => let l = 1, i=2, r=4;
                 * => now nums[i] == 2 so we swap it with nums[r]
                 * => now nums = [0,1,0,1,2,2]
                 * => now l = 1, r = 4 and i would be 3 if we dont decreament.
                 * => so after the while loop there would be a 0 between l and r =>
                 * #wrongsolution
                 */
            }
            i++;
        }
    }
}
