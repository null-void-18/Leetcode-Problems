
//Optimized space approach
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else {
                    int up = (i > 0) ? dp[j] : Integer.MAX_VALUE;
                    int left = (j > 0) ? dp[j - 1] : Integer.MAX_VALUE;
                    dp[j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[n - 1];
    }
}





//DP Approach

class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        
        
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                    continue;
                }
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if(i > 0) {
                    left = dp[i-1][j];
                }
                if(j > 0) {
                    right = dp[i][j-1];
                }
                dp[i][j] = grid[i][j] + Math.min(left,right);
            }
        }
        return dp[m-1][n-1];
    }
}



//Memoization Recursion

class Solution {

    int calculate(int i,int j,int dp[][], int grid[][]) {
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(i == 0 && j == 0) return grid[0][0];
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = grid[i][j] + Math.min(calculate(i-1,j,dp,grid),calculate(i,j-1,dp,grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int row[]: dp) {
            Arrays.fill(row,-1);
        }
        return calculate(m-1,n-1,dp,grid);    
    }
}
