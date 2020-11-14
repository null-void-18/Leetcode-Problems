//O(n) solution

class Solution {
public:
    int jump(vector<int>& nums) {
        int count=1,lim=nums[0];
        int maxr=nums[0];
        int n=nums.size();
        
        //base condition
        if(n<2) return 0;
        
        //run loop once and find the maximum reachable position
        for(int i=1;i<n;i++){
            if(i > lim){
                count++;
                lim=maxr;
            }
            maxr=max(maxr,i+nums[i]);
        }
        
        //return the number of jumps
        return count;
    }
};
