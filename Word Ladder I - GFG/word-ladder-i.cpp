//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    int wordLadderLength(string startWord, string targetWord, vector<string>& wordList) {
        int n = startWord.length();
        set<string> s;
        map<string,int> mp;
        mp[startWord] = 1;
        s.insert(startWord);
        for(int i = 0; i < wordList.size();i++) {
            s.insert(wordList[i]);
        }
        
        int size = s.size();
        int k = 0;
        for(auto st : s) {
            
            mp[st] = k;
            k++;
        }
        
        if(size != wordList.size()) {
            wordList.push_back(startWord);
        }
        if(s.find(targetWord) == s.end()) {
            return 0;
        }
        vector<int> adj[size];
        
        for(int i = 0;i < size;i++) {
            for(int j = 0;j < size;j++) {
                int count = 0;
                for(int z = 0; z < n;z++) {
                    if(wordList[i][z] != wordList[j][z]) {
                        count++;
                    }
                }
                if(count == 1) {
                    adj[mp[wordList[i]]].push_back(mp[wordList[j]]);
                }
            }
        }
        
        
        int src = mp[startWord];
        
        int destination = mp[targetWord];
        vector<int> vis(size,0);
        vector<int> ans(size,INT_MAX);
        queue<pair<int,int>> q;
        q.push({src,0});
        while(!q.empty()) {
            int first = q.front().first;
            int second = q.front().second;
            vis[first] = 1;
            q.pop();
            
            for(auto it:adj[first]) {
                if(vis[it]) {
                    ans[it] = min(ans[it],second+1);
                }
                else{
                    ans[it] = min(ans[it],second+1);
                    q.push({it,second+1});
                }
            }
            
            
        }
        
        
        return (ans[destination] == INT_MAX) ? 0 : ans[destination]+1;
        
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<string>wordList(n);
		for(int i = 0; i < n; i++)cin >> wordList[i];
		string startWord, targetWord;
		cin >> startWord >> targetWord;
		Solution obj;
		int ans = obj.wordLadderLength(startWord, targetWord, wordList);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends