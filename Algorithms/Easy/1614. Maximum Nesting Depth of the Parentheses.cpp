class Solution {
public:
    int maxDepth(string s) {
        int ans=0,check=0;
        
        for(auto i:s){
            if(i=='(') check++;
            if(i==')') check--;
            if(check>ans) ans=check;
        }
        return ans;
    }
};
