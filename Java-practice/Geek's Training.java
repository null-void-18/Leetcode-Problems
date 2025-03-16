
//Both recursive & bottom up approach

class Solution {
    
    
    public int helper(int arr[][],int[][] dp,int row,int prev) {
        if(row == 0) {
            int max = 0;
            for(int i = 0;i < 3;i++) {
                if(i == prev) {
                    continue;
                }
                max = Math.max(max,arr[0][i]);
            }
            return max;
        }
        
        if(dp[row][prev] != -1) return dp[row][prev];
        
        int max = 0;
        
        for(int i = 0;i < 3;i++) {
            if(i == prev) {
                continue;
            }
            max = Math.max(max,arr[row][i] + helper(arr,dp,row-1,i));
        }
        return dp[row][prev] = max;
    }
    
    
    public int maximumPoints(int arr[][]) {
        int n = arr.length;
        int dp[][] = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        
        int max = 0;
        
        for(int i = 0;i < 3;i++) {
            dp[0][i] = arr[0][i];
        }
        
        
        for(int i = 1; i < n;i++) {
            dp[i][0] = arr[i][0] + Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.max(dp[i-1][1],dp[i-1][0]);
        }
        
        for(int i = 0; i < 3;i++) {
            max = Math.max(dp[n-1][i],max);
        }
        return max;
    }
}
