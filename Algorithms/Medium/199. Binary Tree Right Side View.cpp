class Solution {
public:
    void dfs(TreeNode* p,vector<int> &ans,int level,int &max){
        if(!p) return;
        if(level > max){
            ans.push_back(p->val);
            ++max;
        }
        dfs(p->right,ans,level+1,max);
        dfs(p->left,ans,level+1,max);
    }
    
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ans;
        if(!root) return ans;
        int max=-1;
        dfs(root,ans,0,max);
        return ans;
    }
};
