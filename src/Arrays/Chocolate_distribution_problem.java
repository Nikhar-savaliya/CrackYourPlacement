package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Chocolate_distribution_problem {
    public static void main(String[] args) {
        int[] arr = { 7, 3, 2, 4, 9, 12, 56 };
        System.out.println(findMinDiff(arr, 7, 3));
    }

    /**
     * 
     * @time => O(N*logN) + O(n-m) => O(n*logn)
     * @space => O(1)
     * @return
     */

    // for Array
    public static int findMinDiff(int[] a, int n, int m) {
        // your code here
        Arrays.sort(a);
        int left = 0;
        int right = m - 1;
        int ans = a[right] - a[left];
        for (int i = 0; i < n - m; i++) {
            ans = Math.min(ans, a[right] - a[left]);
            right++;
            left++;
        }

        return ans;
    }

    // for array list(GFG answer)
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        Collections.sort(a);

        long minDiff = Long.MAX_VALUE;

        for (int i = 0; i + m - 1 < n; i++) {
            long diff = a.get(i + m - 1) - a.get(i);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}
