

//Bottom up Approach

class Solution {

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][n];
        for(int dp2[][]: dp) {
            for(int dp3[]: dp2) {
                Arrays.fill(dp3,-1);
            }
        }

        for(int i = 0; i < n;i++) {
            for(int j = 0;j < n;j++) {
                if(i == j) {
                    dp[m-1][i][j] = grid[m-1][j];
                }
                else {
                    dp[m-1][i][j] = grid[m-1][i] + grid[m-1][j];
                }
            }
        }


        for(int row = m-2;row >= 0;row--) {
            for(int robo1 = 0; robo1 < n;robo1++) {
                for(int robo2 = 0;robo2 < n;robo2++) {
                    if (robo1 < 0 || robo2 < 0 || robo1 == n || robo2 == n) continue;

                    int ans = 0;
                    if (robo1 == robo2) {
                        for (int i = -1; i < 2; i++) {
                            for (int j = -1; j < 2; j++) {
                                int nextRobo1 = robo1 + i;
                                int nextRobo2 = robo2 + j;
                                if (nextRobo1 >= 0 && nextRobo1 < n && nextRobo2 >= 0 && nextRobo2 < n) {
                                    ans = Math.max(ans, dp[row + 1][nextRobo1][nextRobo2]);
                                }
                            }
                        }
                        dp[row][robo1][robo2] = grid[row][robo1] + ans;
                    } else {

                        for (int i = -1; i < 2; i++) {
                            for (int j = -1; j < 2; j++) {
                                int nextRobo1 = robo1 + i;
                                int nextRobo2 = robo2 + j;
                                if (nextRobo1 >= 0 && nextRobo1 < n && nextRobo2 >= 0 && nextRobo2 < n) {
                                    ans = Math.max(ans, dp[row + 1][nextRobo1][nextRobo2]);
                                }
                            }
                        }
                        dp[row][robo1][robo2] = grid[row][robo1] + grid[row][robo2] + ans;
                    }
                }
            }
        }

        return dp[0][0][n-1];
    }
}





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
