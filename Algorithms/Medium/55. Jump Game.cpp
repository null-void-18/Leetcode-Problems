//O(n) solution

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n=nums.size();
        int maxr=nums[0];
        int lim=nums[0];
        
        //base condition
        if((lim==0) and (n!=1)) return false;
        
        //run loop once and find the maximum reachable position
        for(int i=1;i<n;i++){
            if(i>lim){
                lim=maxr;
                if(lim<i) return false;
            }
            
            maxr=max(maxr,i+nums[i]);
        }
        
        //if the max reachable position is greater than array size then return true
        //else return false 
        
        if(lim>=n-1) return true;
        
        return false;
        
    }
};
