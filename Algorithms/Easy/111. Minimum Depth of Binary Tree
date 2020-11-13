class Solution {
public:
   int findD(TreeNode* root){
        if(!root) return 99999999; 
        if(!root->left && !root->right) return 1;
        return 1 + min(findD(root->left), findD(root->right));
    }
    int minDepth(TreeNode* root) {
        if(!root) return 0;
        return findD(root);
    }
};
