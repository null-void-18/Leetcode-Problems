

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1]; 

        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {
                int exclude = dp[index + 1][prevIndex + 1];

                int include = 0;
                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    include = 1 + dp[index + 1][index + 1];
                }

                dp[index][prevIndex + 1] = Math.max(exclude, include);
            }
        }

        return dp[0][0];
    }
}
