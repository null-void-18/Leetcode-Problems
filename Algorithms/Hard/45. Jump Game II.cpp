class Solution {
public:
    int jump(vector<int>& nums) {
        int count=1,lim=nums[0];
        int maxr=nums[0];
        int n=nums.size();
        
        if(n<2) return 0;
        
        for(int i=1;i<n;i++){
            if(i > lim){
                count++;
                lim=maxr;
            }
            maxr=max(maxr,i+nums[i]);
        }
        return count;
    }
};
