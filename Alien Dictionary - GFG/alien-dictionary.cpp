//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
    public:
    string findOrder(string dict[], int N, int K) {
        vector<int> adj[K];
        
        for(int i = 0; i < N-1;i++) {
            string s1 = dict[i];
            string s2 = dict[i+1];
            for(int x = 0; x < min(s1.length(),s2.length());x++) {
                if(s1[x] != s2[x]) {
                    adj[s1[x] - 'a'].push_back(s2[x] - 'a');
                    // cout<<s1[x] - 'a';
                    // cout<<s2[x] - 'a'<<endl;
                    break;
                }
            }
        }
        
        string ans = "";
        
        vector<int> in(K,0);
        
        for(int i = 0; i < K;i++) {
            for(auto it: adj[i]) {
                in[it]++;
            }
            // cout<<i;
        }
        queue<int> q;
        for(int i = 0; i < K;i++) {
            if(in[i] == 0) {
                q.push(i);
            }
        }
        
        while(!q.empty()) {
            int first = q.front();
            q.pop();
            ans += char(first+97);
            // cout<<first;
            for(auto it : adj[first]) {
                in[it]--;
                if(in[it] == 0) {
                    q.push(it);
                }
            }
        }
        //cout<<ans;
        return ans;
    }
};

//{ Driver Code Starts.
string order;
bool f(string a, string b) {
    int p1 = 0;
    int p2 = 0;
    for (int i = 0; i < min(a.size(), b.size()) and p1 == p2; i++) {
        p1 = order.find(a[i]);
        p2 = order.find(b[i]);
        //	cout<<p1<<" "<<p2<<endl;
    }

    if (p1 == p2 and a.size() != b.size()) return a.size() < b.size();

    return p1 < p2;
}

// Driver program to test above functions
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, K;
        cin >> N >> K;
        string dict[N];
        for (int i = 0; i < N; i++) cin >> dict[i];
        
        Solution obj;
        string ans = obj.findOrder(dict, N, K);
        order = "";
        for (int i = 0; i < ans.size(); i++) order += ans[i];

        string temp[N];
        std::copy(dict, dict + N, temp);
        sort(temp, temp + N, f);

        bool f = true;
        for (int i = 0; i < N; i++)
            if (dict[i] != temp[i]) f = false;

        if(f)cout << 1;
        else cout << 0;
        cout << endl;
    }
    return 0;
}

// } Driver Code Ends