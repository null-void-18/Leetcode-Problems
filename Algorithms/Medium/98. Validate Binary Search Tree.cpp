class Solution {
public:
    void inorder(TreeNode* p,vector<int> &ans){
        if(!p) return;
        inorder(p->left,ans);
        ans.push_back(p->val);
        inorder(p->right,ans);
        return;
    }
    
    bool isValidBST(TreeNode* root) {
        if(!root) return true;
        vector<int> ans;
        inorder(root,ans);
        for(int i=0;i<ans.size()-1;i++){
            if(ans[i] >= ans[i+1]) return false;
        }
        return true;
    }
};
