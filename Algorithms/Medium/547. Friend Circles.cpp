class Solution {
public:
    void dfs(vector<vector<int>> M,vector<bool> &visited,int i){
        visited[i]=true;
        for(int j=0;j<M[0].size();j++){
            if(j!=i and M[i][j] == 1 and !visited[j]) dfs(M,visited,j);
        }
        return;
    }
    
    int findCircleNum(vector<vector<int>>& M) {
        vector<bool> visited(M.size(),false);
        int count=0;
        if(M.empty()) return 0;
        for(int i=0;i<M.size();i++){
            if(!visited[i]){
                count++;
                dfs(M,visited,i);
            }
        }
        return count;
    }
};
