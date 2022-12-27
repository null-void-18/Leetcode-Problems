#include <bits/stdc++.h> 

int findans(int i,int j,int a,int b,int r,int c,vector<vector<int>> &grid,vector<vector<vector<int>>> &dp) {
    
    if(j < 0 or j == c or b < 0 or b == c) return 0;
    
    if(i == r-1) {
        if(j == b) {
            return dp[i][j][j] = grid[i][j];
        }
        return dp[i][j][b] = grid[i][j] + grid[a][b];
    }
    if(dp[i][j][b] != -1) return dp[i][j][b];
    int maxi = 0;
    for(int k = 0;k < 3;k++) {
        int left = findans(i+1,j+k-1,a+1,b-1,r,c,grid,dp);
        int down = findans(i+1,j+k-1,a+1,b,r,c,grid,dp);
        int right = findans(i+1,j+k-1,a+1,b+1,r,c,grid,dp);
        maxi = max(maxi,max(left,max(right,down)));
    }
    if(j == b) {
        return dp[i][j][j] = maxi + grid[i][j];
    }
    return dp[i][j][b] = maxi + grid[i][j] + grid[a][b];
}

int maximumChocolates(int r, int c, vector<vector<int>> &grid) {
    vector<vector<vector<int>>> dp(r,vector<vector<int>> (c,vector<int> (c,-1)));
    return findans(0,0,0,c-1,r,c,grid,dp);
}



