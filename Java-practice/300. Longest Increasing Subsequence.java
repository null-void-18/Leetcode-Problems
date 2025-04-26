//Another brilliant solution -- More like insertion sort

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp,1);

        int ans = 1;
        for(int i = 1;i < n;i++) {
            for(int j = 0;j < i;j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(1 + dp[j],dp[i]);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}




//Space optimized DP Approach 

class Solution {
        public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int after[] = new int[n+1],curr[] = new int[n+1];

        for(int index = n-1; index >= 0; index--) {
            for(int prevIndex = index-1; prevIndex >= -1; prevIndex--) {
                int exclude = after[prevIndex+1]; 
                int include = 0;
                if(prevIndex == -1 || nums[prevIndex] < nums[index]) {
                    include = 1 + after[index+1];
                }
                curr[prevIndex+1] = Math.max(include, exclude);
            }
            for (int i = 0; i < curr.length; i++) {
                after[i] = curr[i];
            }
        }

        return after[0];
    }
}



//DP Approach

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
