class Solution {
public:
    bool isSubsequence(string s, string t) {
        int n=t.length();
        int m=s.length();
        if(m>n) return false;
        
        int count=0;
        int j=0;
        for(int i=0;i<n;++i){
            if(s[j]==t[i]){
                ++count;
                ++j;
            }
            if(j==m) break;
        }
        return count==m;
    }
};
