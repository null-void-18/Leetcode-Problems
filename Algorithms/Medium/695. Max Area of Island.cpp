class Solution {
public:
    int dfs(vector<vector<int>>& grid,vector<vector<bool>>& visited,int i,int j){
        if(i<0 || i>=grid.size() || j<0 || j>=grid[i].size() || visited[i][j] || grid[i][j]==0) return 0;
        visited[i][j]=true;
        return 1+dfs(grid,visited,i-1,j)+dfs(grid,visited,i,j-1)+dfs(grid,visited,i,j+1)+dfs(grid,visited,i+1,j);
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int ans=0;
        vector<vector<bool>> visited(grid.size(),vector<bool>(grid[0].size(),false));
        
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[i].size();j++){
                int temp=dfs(grid,visited,i,j);
                ans=max(ans,temp);
            }
        }
        return ans;
    }
};
