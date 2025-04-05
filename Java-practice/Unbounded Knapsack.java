
//DP Approach


public class Solution {

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int dp[][] = new int[n][w+1];
        
        for(int i = 0; i <= w;i++) {
            if(weight[0] <= i) {
                dp[0][i] = (i / weight[0]) * profit[0];
            }
        }
        
        for(int i = 0; i < n;i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i < n;i++) {
            for(int j = 1; j <= w;j++) {
                int take = 0;
                if(j-weight[i] >= 0) {
                    take = profit[i] + dp[i][j-weight[i]];
                }
                int notTake = dp[i-1][j];

                dp[i][j] = Math.max(take,notTake);
            }
        }



        return dp[n-1][w];
    }
}






//Recursion with Memoization


public class Solution {
    private static int calculate(int n,int w,int profit[],int weight[],int dp[][]) {
        if(n < 0 || w < 0) {
            return 0;
        }

        if(dp[n][w] != -1) return dp[n][w];

        int take = 0;
        if(w-weight[n] >= 0) {
            take = profit[n] + calculate(n,w-weight[n],profit,weight,dp);
        }

        int notTake = calculate(n-1,w,profit,weight,dp);

        return dp[n][w] = Math.max(take,notTake);

    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int dp[][] = new int[n][w+1];
        
        for(int row[] : dp) {
            Arrays.fill(row,-1);
        }

        return calculate(n-1,w,profit,weight,dp);
    }
}
