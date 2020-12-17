class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> ans={0};
        int cur=1;
        if(!num) return ans;
        int a[num+10];
        memset(a,0,sizeof a);
        for(int i=1;i<=num;++i){
            if(i==2*cur) cur=i;
            a[i]=a[i-cur]+1;
            ans.push_back(a[i]);
        }
        return ans;
    }
};
