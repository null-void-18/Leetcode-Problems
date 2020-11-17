class Solution {
public:
    int height(TreeNode* root){
        if(!root) return 0;
        int l=height(root->left)+1;
        int r=height(root->right)+1;
        return max(l,r);
    }
    
    bool isBalanced(TreeNode* root) {
        if(!root) return true;
        int hl=height(root->left);
        int hr=height(root->right);
        if(abs(hl-hr)>1)
            return false;
        return (isBalanced(root->left) && isBalanced(root->right));
    }
};
