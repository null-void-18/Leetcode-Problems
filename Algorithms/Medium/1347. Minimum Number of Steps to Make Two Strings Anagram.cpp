class Solution {
public:
    int minSteps(string s, string t) {
        int ans=0;
        vector<int> a(26,0);
        for(int i=0;i<t.length();i++){
            a[t[i]-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            if(a[s[i]-'a']) a[s[i]-'a']--;
        }
        
        for(int i=0;i<26;i++) ans+=a[i];
        
        return ans;
    }
};
