class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        int even=0,odd=0,new_even=0,new_odd=0;
        int ans=0;
        for(int i=0;i<nums.size();i++){
            if(!(i%2)) even+=nums[i];
            else odd+=nums[i];
        }
        
        for(int i=0;i<nums.size();i++){   
            if(i%2==0){
                even-=nums[i];
                if((even+new_odd)==(odd+new_even))
                    ans++;
                new_even+=nums[i];
            }
            else{
                odd-=nums[i];
                if((even+new_odd)==(odd+new_even))
                    ans++;
                new_odd+=nums[i];
            }
        }
        return ans;
    }
};
