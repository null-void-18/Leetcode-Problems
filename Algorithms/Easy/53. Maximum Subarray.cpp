class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int ans=nums[0];
        int n=nums.size();
        vector<int> count(n,0);
        if(n==1) return nums[0];
        count[0]=nums[0];
        
        for(int i=1;i<n;++i){
            count[i]=max(nums[i],nums[i]+count[i-1]);
            if(count[i]>ans){
                ans=count[i];
            }
        }
        return ans;
    }
};
