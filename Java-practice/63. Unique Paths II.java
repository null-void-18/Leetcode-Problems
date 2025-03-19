

//Bottom up
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if (obstacleGrid[0][0] == 1) return 0;

        int[] dp = new int[n];
        dp[0] = 1; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;  
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}




//Memoization Recursion

class Solution {

    int calculate(int i,int j,int dp[][], int[][] grid) {
        if(i < 0 || j < 0 || grid[i][j] == 1) return 0;

        if(i == 0 && j == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = calculate(i-1,j,dp,grid) + calculate(i,j-1,dp,grid);
    }



    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int row[] : dp) {
            Arrays.fill(row,-1);
        }
        return calculate(m-1,n-1,dp,obstacleGrid);
    }
}
