class Solution {
public:
    set<pair<int,int>> s;
    void dfs(vector<int> adlist[],vector<bool> &visited,int n){
        visited[n]=true;
        
        for(auto i:adlist[n]){
            if(!visited[i]){
                s.insert({i,n});
                dfs(adlist,visited,i);
            }
        }
        return;
    }
    
    int minReorder(int n, vector<vector<int>>& connections) {
        vector<int> adlist[n];
        vector<bool> visited(n,false);
        
        for(auto i:connections){
            adlist[i[0]].push_back(i[1]);
            adlist[i[1]].push_back(i[0]);
        }
        
        dfs(adlist,visited,0);
        
        for(int i=0;i<connections.size();i++){
            pair<int,int> p={connections[i][0],connections[i][1]};
            
            if(s.find(p) != s.end()) s.erase(p);
        }
        return s.size();
    }
};
