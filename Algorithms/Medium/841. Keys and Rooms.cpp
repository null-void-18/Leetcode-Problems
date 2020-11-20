class Solution {
public:
    void dfs(vector<vector<int>> rooms,vector<bool>& visited,int index){
        visited[index]=true;
        for(int i=0;i<rooms[index].size();i++){
            if(!visited[rooms[index][i]])
                dfs(rooms,visited,rooms[index][i]);
        }
    }
    
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        if(!rooms.size()) return false;
        vector<bool> visited(rooms.size(),false);
        dfs(rooms,visited,0);
        for(auto i:visited){
            if(!i) return false;
        }
        return true;
    }
};
