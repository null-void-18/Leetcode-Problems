//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
     vector<int> shortestPath(int N,int M, vector<vector<int>>& edges){
        vector<int> adj[N];
        map<pair<int,int>,int> mp;
        for(int i = 0;i < M;i++) {
            adj[edges[i][0]].push_back(edges[i][1]);
            mp[{edges[i][0],edges[i][1]}] = edges[i][2];
        }
        
        vector<int> ans(N,INT_MAX);
        queue<pair<int,int>> q;
        
        q.push({0,0});
        ans[0] = 0;
        vector<int> in(N,0);
        
        for(int i = 0; i < N;i++) {
            for(auto it : adj[i]) {
                in[it]++;
            }
        }
        
        for(int i = 1; i < N;i++) {
            if(in[i] == 0) {
                for(auto it:adj[i]) {
                    in[it]--;
                }
            }
        }
        
        while(!q.empty()) {
            int first = q.front().first;
            int second = q.front().second;
            q.pop();
            
            for(auto it:adj[first]) {
                in[it]--;
                if(in[it] == 0) {
                    ans[it] = min(ans[it],second+mp[{first,it}]);
                    q.push({it,ans[it]});
                }
                else{
                    ans[it] = min(ans[it],second+mp[{first,it}]);
                }
            }
        }
        
        for(int i = 0;i < N;i++) {
            if(ans[i] == INT_MAX) {
                ans[i] = -1;
            }
        }
        return ans; 
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> edges;
        for(int i=0; i<m; ++i){
            vector<int> temp;
            for(int j=0; j<3; ++j){
                int x; cin>>x;
                temp.push_back(x);
            }
            edges.push_back(temp);
        }
        Solution obj;
        vector<int> res = obj.shortestPath(n, m, edges);
        for (auto x : res) {
            cout << x << " ";
        }
        cout << "\n";
    }
}

// } Driver Code Ends