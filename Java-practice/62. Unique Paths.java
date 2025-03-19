

//Bottom-up DP approach
class Solution {

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        for(int i = 0;i < m;i++) {
            dp[i][0] = 1;
        }

        for(int i = 0;i < n;i++) {
            dp[0][i] = 1;
        }

        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}





//Recursive solution (with memoization):
class Solution {

    int calculate(int[][] dp,int m,int n,int i,int j) {
        if(i < 0 || j < 0 || i == m || j == n) return 0;
        if(i == m-1 && j == n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = calculate(dp,m,n,i+1,j) + calculate(dp,m,n,i,j+1);
    }


    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row,-1);
        }
        return calculate(dp,m,n,0,0);
    }
}
