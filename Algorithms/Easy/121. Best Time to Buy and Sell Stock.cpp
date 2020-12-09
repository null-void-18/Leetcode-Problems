class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        if(n==0) return 0;
        vector<int> pre(n),suff(n);
        pre[0]=prices[0];
        for(int i=1;i<n;i++) {
            if(prices[i]<pre[i-1]) pre[i]=prices[i];
            else pre[i]=pre[i-1];
        }
        suff[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--) {
            if(prices[i]>suff[i+1]) suff[i]=prices[i];
            else suff[i]=suff[i+1];
        }
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            if(suff[i]>pre[i])
                ans=max(ans,suff[i]-pre[i]);
        }
        return ans;
    }
};
