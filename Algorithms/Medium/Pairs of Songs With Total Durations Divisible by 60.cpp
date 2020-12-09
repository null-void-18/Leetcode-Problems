class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        vector<int> a(60,0);
        int ans=0;
        
        for(int t:time){
            if(t%60==0){
                ans+=a[0];
            }
            else{
                ans+=a[60-t%60];
            }
            a[t%60]++;
        }
        return ans;
    }
};
