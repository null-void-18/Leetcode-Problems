class Solution {
public:
    void dfs(TreeNode* root,int &ans){
        if(!root) return;
        dfs(root->right,ans);
        ans+=root->val;
        root->val=ans;
        dfs(root->left,ans);
        return;
    }
    
    TreeNode* bstToGst(TreeNode* root) {
        int ans=0;
        dfs(root,ans);
        return root;
    }
};
