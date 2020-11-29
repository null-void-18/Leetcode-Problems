class Solution {
public:
    int numSplits(string s) {
        int good=0;
        vector<int> l(26,0),r(26,0);
        int left=1,right=0;
        for(int i=1;i<s.length();i++){
            if(r[s[i]-'a']==0) right++;
            r[s[i]-'a']++;
        }
        ++l[s[0]-'a'];
        if(left==right) good++;
        
        for(int i=2;i<s.length();i++){
            if(l[s[i-1]-'a']==0) left++;
            ++l[s[i-1]-'a'];
            if(--r[s[i-1]-'a']==0) right--;
            if(left==right) good++;
        }
        return good;
    }
};
