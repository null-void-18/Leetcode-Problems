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
    
    int countnodes(TreeNode* root) {
        if(root == NULL) {
            return 0;
        }
        int left = countnodes(root->left);
        int right = countnodes(root->right);
        return left+right+1;
    }
    
    int findnodes(TreeNode* root,int &ans) {
        if(root == NULL) {
            return 0;
        }
        int left = findnodes(root->left,ans);
        int right = findnodes(root->right,ans);
        
        if(round(((left + right + root->val) / countnodes(root))) == root->val) {
            ans++;
        }
        return left + right + root->val;
    }
    
    
    int averageOfSubtree(TreeNode* root) {
        int ans = 0;
        findnodes(root,ans);
        return ans;
    }
};