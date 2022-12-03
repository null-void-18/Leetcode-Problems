//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
    private:
    
    bool isVowel(char a) {
        if(a == 'a' || a == 'i' or a =='o' || a == 'e' or a == 'u') return true;
        return false;
    }
    
    void printAll(set<string> &ans,string s,string st,int i,int n) {
        if(i > n) return;
        
        if(st.size() > 1) {
            if(isVowel(st[0]) && !isVowel(st[st.size()-1])) {
                ans.insert(st);
            }
        }
        
        printAll(ans,s,st,i+1,n);
        printAll(ans,s,st+s[i],i+1,n);
        
    }
    
  public:
    set<string> allPossibleSubsequences(string s) {
        string st = "";
        set<string> ans;
        int n = s.length();
        
        printAll(ans,s,st,0,n);
        
        return ans;
        
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        cin >> S;
        Solution ob;
        set<string> ans = ob.allPossibleSubsequences(S);
        if (ans.size() == 0)
            cout << -1 << endl;
        else {
            for (auto i : ans) cout << i << " ";
            cout << endl;
        }
    }
    return 0;
}

// } Driver Code Ends