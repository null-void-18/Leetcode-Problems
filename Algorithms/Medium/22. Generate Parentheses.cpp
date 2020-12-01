class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        dfs(ans,"",0,0,n);
        return ans;
    }
    
    void dfs(vector<string>& ans,string s,int open,int close,int max){
        if(s.length()==max*2){
            ans.push_back(s);
            return;
        }
        if(open<max){
            dfs(ans,s+'(',open+1,close,max);
        }
        if(close<open){
            dfs(ans,s+')',open,close+1,max);
        }
    }
    
};
