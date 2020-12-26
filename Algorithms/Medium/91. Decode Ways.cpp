class Solution {
public:
    int numDecodings(string s) {
        if(s[0]=='0') return 0;
        int n=s.length();
        if(n==1) return 1;
        vector<int> dp(n+1,0);
        dp[0]=dp[1]=1;
        for(int i=2;i<=n;++i){
            int one=s[i-1]-'0';
            int two=(s[i-2]-'0')*10+(s[i-1]-'0');
            if(one>=1) dp[i]+=dp[i-1];
            if(two>=10 and two<=26) dp[i]+=dp[i-2];
        }
        return dp[n];
    }
};
