
class Solution {

    //Recursive implementation
    int cost(int height[],int len,int start,int prev) {
        if(start >= len) return Integer.MAX_VALUE;
        if(start == len - 1) {
            return Math.abs(height[start] - height[prev]);
        }
        
        return Math.min(cost(height,len,start+1,start),cost(height,len,start+2,start)) + 
        Math.abs(height[start] - height[prev]);
    }
    
    //DP Approach
    int minCost(int[] height) {
        int n = height.length;
        int dp[] = new int[n];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return Math.abs(height[0] - height[1]);
        }
        
        dp[0] =  0;
        dp[1] = Math.abs(height[0] - height[1]);
        for(int i = 2;i < n;i++) {
            dp[i] = Math.min(dp[i-1] + Math.abs(height[i] - height[i-1]),
            dp[i-2] + Math.abs(height[i] - height[i-2]));
        }
        return dp[n-1];
    }
}
