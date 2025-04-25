

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




//Recursion with Memoization

class Solution {


    public int calculate(int index,int prevIndex,int nums[],int dp[][]) {
        if(index == nums.length) return 0;

        if(dp[index][prevIndex+1] != -1) return dp[index][prevIndex+1];

        int exclude = calculate(index+1,prevIndex,nums,dp);
        int include = 0;
        if(prevIndex == -1 || nums[prevIndex] < nums[index]) {
            include = 1 + calculate(index+1,index,nums,dp);
        }

        return dp[index][prevIndex+1] = Math.max(exclude,include);
    }



    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];

        for(int rows[] : dp) {
            Arrays.fill(rows,-1);
        }

        return calculate(0,-1,nums,dp);
    }
}
