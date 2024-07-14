package Arrays;

import java.util.Arrays;

public class Move_zeros {
  public static void main(String[] args) {
    int[] nums = { 0, 1, 0, 3, 12 };

    nums = moveZeroes(nums);

    System.out.println(Arrays.toString(nums));
  }

  /**
   * !! brute force solution
   * 
   * @time => O(N)
   * @space => O(N)
   */
  public static int[] Brute_moveZeroes(int[] nums) {
    int[] temp = new int[nums.length];
    int index = 0;
    for (int i : nums) {
      if (i != 0) {
        temp[index++] = i;
      }
    }
    return temp;
  }

  /**
   * !! Optimal solution
   * 
   * @approach => use 2 pointers, one pointer to maintain the zeros and other to
   *           iterate over array.
   * @time => ~ O(n)
   * @space => O(1)
   */

  public static int[] moveZeroes(int[] nums) {

    int j = -1;

    // find first 0's index
    for (int x = 0; x < nums.length; x++) {
      if (nums[x] == 0) {
        j = x;
        break;
      }
    }

    // if no 0 found return here
    if (j == -1)
      return nums;

    // moving all zero to last
    for (int i = j + 1; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        j++;
      }
    }
    return nums;
  }
}
