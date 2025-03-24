
//Memoization with recursion

class Solution {

    int calculate(int robo1,int robo2,int row, int n,int m,int dp[][][],int grid[][]) {
        if(robo1 < 0 || robo2 < 0 || robo1 == n || robo2 == n || row == m) return 0;
        if(dp[row][robo1][robo2] != -1) return dp[row][robo1][robo2];
        if(robo1 == robo2) {
            int ans = 0;
            for(int i = -1;i < 2;i++) {
                for(int j = -1;j < 2;j++) {
                    ans = Math.max(ans,calculate(robo1 + i,robo2 + j,row + 1,n,m,dp,grid));
                }
            } 
        return dp[row][robo1][robo2] = grid[row][robo1] + ans;
        }else {
            int ans = 0;
            for(int i = -1;i < 2;i++) {
                for(int j = -1;j < 2;j++) {
                    ans = Math.max(ans,calculate(robo1 + i,robo2 + j,row + 1,n,m,dp,grid));
                }
            } 
        return dp[row][robo1][robo2] = grid[row][robo1] + grid[row][robo2] + ans;
        }
    }


    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][n];
        for(int dp2[][]: dp) {
            for(int dp3[]: dp2) {
                Arrays.fill(dp3,-1);
            }
        }
        return calculate(0,n-1,0,n,m,dp,grid);
    }
}
