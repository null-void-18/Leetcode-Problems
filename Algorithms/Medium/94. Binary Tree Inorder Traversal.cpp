Recursive Solution:

class Solution {
public:

    vector<int> a;
    
    vector<int> inorderTraversal(TreeNode* root) {
        if(root == NULL){
            return a;
        }
        else{
            inorderTraversal(root->left);
            a.push_back(root->val);
            inorderTraversal(root->right);
        }
        return a;
    }
};
