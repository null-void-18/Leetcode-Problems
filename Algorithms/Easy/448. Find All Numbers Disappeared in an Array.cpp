class Solution {
public:
    Solution(){
        ios_base::sync_with_stdio(0);
        cin.tie(0);
    }
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int n=nums.size();
        vector<int> dp(n+1, 0), ans;
        
        for(int i=0; i<n; i++){
            dp[nums[i]]++;
        }
        
        for(int i=1; i<=n; i++){
            if(dp[i]==0){
                ans.push_back(i);
            }
        }
        
        return ans;
    }
};
