class NumArray {
public:
    vector<int> dp;
    NumArray(vector<int>& nums) {
        if(nums.size()==0)
            return ;
        dp.push_back(nums[0]);
        for(int i=1;i<nums.size();i++)
        {
            dp.push_back(dp[i-1]+nums[i]);
        }
    }
    
    int sumRange(int i, int j) {
        if(i>0)
            return dp[j]-dp[i-1];
        else return dp[j];
    }
};
