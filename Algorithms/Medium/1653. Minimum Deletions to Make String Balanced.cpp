class Solution {
public:
    int minimumDeletions(string s) {
        int pre[100005];
        pre[0]=0;
        for(int i = 0;i<s.size();i++){
            pre[i+1]=pre[i];
            if(s[i]=='b')pre[i+1]++;
        }
        int suf[100005];
        suf[s.size()]=0;
        for(int i = s.size()-1;i>=0;i--){
            suf[i]=suf[i+1];
            if(s[i]=='a')suf[i]++;
        }
        int ans=1e9;
        for(int i=0;i<=s.size();i++)ans=min(ans,pre[i]+suf[i]);
        return ans;
    }
};
