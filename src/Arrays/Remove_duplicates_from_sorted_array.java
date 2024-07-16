package Arrays;

import java.util.Arrays;

public class Remove_duplicates_from_sorted_array {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 
     * !! BRUTEFORCE SOLUTION
     * 
     * @approach => use set to store each element then update first x elements from
     *           array.
     * @time => O(n + x); x == time to insert elements in a set.
     * @space => O(x); x == number of unique elements
     * 
     *        !! Optimal solution
     * @approach => two pointers; i and j ; j iterates over the array and when it
     *           finds unique element it inserts at i; i++;
     */

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;

    }
}
