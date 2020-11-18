class Solution {
public:
    void dfs(vector<vector<int>> &graph,int &result,int source,vector<int> path,vector<vector<int>> &paths)
    {
        int n=graph.size();
        path.push_back(source);
        if(source==n-1)
        {
            paths.push_back(path);
            path.clear();
            result++;
            return;
        }  
        for(int i=0;i<graph[source].size();i++)
        {
                dfs(graph,result,graph[source][i],path,paths);
        }
    }
    
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        vector<int> current;
        vector<vector<int>> paths;
        int result=0;
        int source=0;
        dfs(graph,result,0,current,paths);
        return paths;
    }
};
