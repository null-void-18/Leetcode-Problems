class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());
        int i=0,j=nums.size()-1;
        int ans=0;
        
        while(i<j){
            if(nums[j]+nums[i]==k){
                ++i;
                --j;
                ++ans;
            } 
            else if(nums[j]+nums[i]<k){
                ++i;
            }
            else{
                --j;
            }
        }
        return ans;
    }
};
