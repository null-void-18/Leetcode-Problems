class Solution {
public:
    void dfs(vector<vector<int>> &a,int i,int j,int &count){
        if(i<0 || j<0 || i>=a.size() || j>=a[0].size() || !a[i][j]) return;
        count++;
        a[i][j]=0;
        dfs(a,i+1,j,count);
        dfs(a,i,j-1,count);
        dfs(a,i,j+1,count);
        dfs(a,i-1,j,count);
        return;
    }
    
    int numEnclaves(vector<vector<int>>& A) {
        if(A.empty()) return 0;
        int count=0;
        for(int i=0;i<A.size();i++){
            dfs(A,i,0,count);
            dfs(A,i,A[0].size()-1,count);
        }
        for(int i=0;i<A[0].size();i++){
            dfs(A,0,i,count);
            dfs(A,A.size()-1,i,count);
        }
        count=0; 
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A[0].size();j++){
                if(A[i][j]){
                    dfs(A,i,j,count);
                }
            }
        }
        return count;
    }
};
