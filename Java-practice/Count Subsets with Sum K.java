


//DP Approach


public class Solution {
    public static int findWays(int num[], int tar) {
        int n = num.length;
    int m = (int)(1e9+7);
        long[][] dp = new long[n][tar+1];
        for(int i=0;i<n;i++) {
        for(int j=0;j<=tar;j++) {
        if(i == 0) {
        if(j == 0 && num[i] == 0) dp[i][j] = 2;
        else if(j == 0 || j == num[i]) dp[i][j] = 1;
        else dp[i][j] = 0;
        continue;
        }
        long take = 0;
        long notTake = dp[i-1][j]%m;
        if(num[i] <= j) take = dp[i-1][j-num[i]]%m;
        dp[i][j] = (take%m + notTake%m)%m;
        }
        }
        return (int)(dp[n-1][tar]%m);
}
}



//Memoization Approach


public class Solution {
     static final int MOD = 1000000007;

    static int calculate(int n,int target,int dp[][],int nums[]) {
        if(n < 0) {
            if(target == 0) return 1;
            return 0;
        } 
        if(target < 0) return 0;
        if(dp[n][target] != -1) return dp[n][target];
        return dp[n][target] = (calculate(n-1,target,dp,nums) + calculate(n-1,target-nums[n],dp,nums)) % MOD;
    }


    public static int findWays(int nums[], int target) {
        int n = nums.length;

        int dp[][] = new int[n][target+1];


        for(int row[] : dp) {
            Arrays.fill(row,-1);
        }

        return calculate(n-1,target,dp,nums);
    }
}





//Exponential recursion solution

public class Solution {

    static int calculate(int n,int target,int nums[]) {
        if(n < 0) {
            if(target == 0) return 1;
            return 0;
        } 
        if(target < 0) return 0; 
        return calculate(n-1,target,nums) + calculate(n-1,target-nums[n],nums);
    }


    public static int findWays(int nums[], int tar) {
        int n = nums.length;

        return calculate(n-1,tar,nums);
    }
}
