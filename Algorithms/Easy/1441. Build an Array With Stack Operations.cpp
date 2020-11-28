class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        vector<string> res;
        int i=0;
        
        for(int j=0;j<target[target.size()-1];j++){
            res.push_back("Push");
            
            if(j+1==target[i]){
                i++;
            }
            else{
                res.push_back("Pop");
            }
        }
        return res;
    }
};
