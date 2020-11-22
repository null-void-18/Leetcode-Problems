//OPTIMIZED SOLUTION

class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        
        set<string> s;
        for (auto point : paths) s.insert(point[0]);
        for (auto point : paths) if (s.count(point[1]) == 0) return point[1];
        return "";
    }
};


//EASY SOLUTION


class Solution {
public:
    string dfs(vector<vector<string>> paths,string s){
        for(int i=0;i<paths.size();i++){
            if(paths[i][0] == s){
                s=dfs(paths,paths[i][1]);
                break;
            }
        }
        return s;
    }

    string destCity(vector<vector<string>>& paths) {
        return dfs(paths,paths[0][1]);
    }
};
