
//DP approach

class Solution {


    int calculate(int row,int col,int n,int dp[][],int matrix[][]) {
        if(col < 0 || col == n) return Integer.MAX_VALUE;
        if(row == n-1) return matrix[row][col]; 
        if(dp[row][col] != -1) return dp[row][col];
        return dp[row][col] = matrix[row][col] + Math.min(calculate(row+1,col-1,n,dp,matrix),Math.min(calculate(row+1,col,n,dp,matrix),calculate(row+1,col+1,n,dp,matrix)));
    }


    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int n = matrix.length;
        int dp[][] = new int[n][n];


        for(int i = 0; i < n;i++) {
            for(int j = 0;j < n;j++) {
                if(i == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                int left = Integer.MAX_VALUE;
                int up = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if(j > 0) {
                    left = dp[i-1][j-1];
                }
                if(j < n-1) {
                    right = dp[i-1][j+1];
                }
                up = dp[i-1][j];

                dp[i][j] = matrix[i][j] + Math.min(left,Math.min(right,up));
            }
        }

        for(int i = 0;i < n;i++) {
            ans = Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }
}
