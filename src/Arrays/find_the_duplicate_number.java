package Arrays;

import java.util.HashMap;
import java.util.Map;

public interface find_the_duplicate_number {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(Optimal_findDulicate(nums));
    }
    /**
   * !! BruteForce Solution
   * 
   * @time => O(2*n)
   * @space => O(n-1)
   */
  public static int BruteForce_findDuplicate(int[] nums) {

    int ans = -1;

    Map<Integer, Integer> mp = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
      if (entry.getValue() > 1)
        return entry.getKey();
    }

    return ans;
  }

  
  public static int Optimal_findDulicate(int[] nums){
      /**
       * !! Optimal solution (Floyd's cycle detection method)
       * @timeComplexity => O(n)
       * @spaceComplexity => O(1)
       */
    int slow =0, fast = 0;
    while(true){
        slow = nums[slow];
        fast = nums[nums[fast]];
        if(slow == fast){
            break;
        }
    } 
    
    int slow2 = 0;
    while(true){
        slow = nums[slow];
        slow2 = nums[slow2];
        if(slow == slow2){
            return slow;
        }
    }
  }
}
