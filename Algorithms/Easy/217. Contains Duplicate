class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        map<int,int> mp;    
        map<int,int>::iterator itr;
        for(int i=0;i<nums.size();i++)
        {
            mp[nums[i]]++;
        }
        for(itr=mp.begin();itr!=mp.end();itr++)
        {
            if(itr->second>1)
                return true;
        }
        return false;      
    }
};
