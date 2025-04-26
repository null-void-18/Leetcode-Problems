

//Printing LIS 

import java.util.*;

public class Solution {
    public static List<Integer> printingLongestIncreasingSubsequence(int[] nums, int n) {
        int[] dp = new int[n], prev = new int[n];
        Arrays.fill(dp, 1); Arrays.fill(prev, -1);

        int lastIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[lastIndex]) lastIndex = i;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = lastIndex; i != -1; i = prev[i]) res.add(nums[i]);
        Collections.reverse(res);
        return res;
    }
}
