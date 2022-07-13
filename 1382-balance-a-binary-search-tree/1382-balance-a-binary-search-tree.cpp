/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    void inorder(TreeNode* root,vector<int>& ans) {
        if(root == nullptr) {
            return ;
        }
        inorder(root->left,ans);
        ans.push_back(root->val);
        inorder(root->right,ans);
    }
    
    TreeNode* createtree(vector<int> &ans,int i,int j) {
        if(i > j) {
            return nullptr;
        }
        int mid = (i + j)/2;
        TreeNode* root = new TreeNode(ans[mid]);
        root->left = createtree(ans,i,mid-1);
        root->right = createtree(ans,mid+1,j);
        return root;
    }
    
    
    TreeNode* balanceBST(TreeNode* root) {
        vector<int> ans;
        inorder(root,ans);
        return createtree(ans,0,ans.size()-1);
    }
};