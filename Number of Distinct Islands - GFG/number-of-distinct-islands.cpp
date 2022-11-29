//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
    private:
        
    
    void dfs(vector<vector<int>> &grid,vector<vector<int>> &vis,vector<vector<int>> &ans,int i,int j,int rsrc,int csrc,int row,int col) {
        vis[i][j] = 1;
        ans.push_back({i-rsrc,j-csrc});
        
        int directionx[] = {-1,1,0,0};
        int directiony[] = {0,0,-1,1};
        
        for(int k = 0;k < 4;k++) {
            int x = i - directionx[k];
            int y = j - directiony[k];
            
            if(x>=0 and y>=0 and x<row and y<col and grid[x][y]==1 and !vis[x][y]) {
                dfs(grid,vis,ans,x,y,rsrc,csrc,row,col);
            }
        }
        
    }
    
  public:
    int countDistinctIslands(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        int count = 0;
        vector<vector<int>> vis(row, vector<int> (col,0));
        set<vector<vector<int>>> s;
        
        for(int i = 0; i < row;i++) {
            for(int j = 0;j < col;j++) {
                if(grid[i][j] && !vis[i][j]) {
                    vector<vector<int>> ans;
                    
                    dfs(grid,vis,ans,i,j,i,j,row,col);
                    if(s.find(ans) == s.end()) {
                        s.insert(ans);
                        count +=1;
                    }
                    
                }
            }
        }
        return count;
    }
};


//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> grid(n, vector<int>(m));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> grid[i][j];
            }
        }
        Solution obj;
        cout << obj.countDistinctIslands(grid) << endl;
    }
}
// } Driver Code Ends