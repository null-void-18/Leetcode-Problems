//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    vector<int> shortestPath(vector<vector<int>>& edges, int N,int M, int src){
         vector<int> adj[N];
        
        vector<int> vis(N,0);
        vector<int> ans(N,INT_MAX);
        queue<pair<int,int>> q;
        
        for(int i = 0; i< M;i++) {
            adj[edges[i][0]].push_back(edges[i][1]);
            adj[edges[i][1]].push_back(edges[i][0]);
        }
        
        
        q.push({src,0});
        ans[src] = 0;
        
        while(!q.empty()) {
            int first = q.front().first;
            int second = q.front().second;
            q.pop();
            vis[first] = 1;
            for(auto it : adj[first]) {
                if(vis[it] == 0){
                    q.push({it,second+1});
                    ans[it] = min(ans[it],second+1);
                }
                else{
                    ans[it] = min(ans[it],second+1);
                }
            }
            
        }
        
        for(int i = 0; i < N;i++) {
            if(ans[i] == INT_MAX) ans[i] = -1; 
        }
        return ans;
     
        // code here
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m; cin >> n >> m;
        vector<vector<int>> edges;

        for (int i = 0; i < m; ++i) {
            vector<int> temp;
            for(int j=0; j<2; ++j){
                int x; cin>>x;
                temp.push_back(x);
            }
            edges.push_back(temp);
        }

        int src; cin >> src;

        Solution obj;

        vector<int> res = obj.shortestPath(edges, n, m, src);

        for (auto x : res){
            cout<<x<<" ";
        }
        cout << "\n";
    }
}

// } Driver Code Ends