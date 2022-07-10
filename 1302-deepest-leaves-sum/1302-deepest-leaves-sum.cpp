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
    
    void getheight(TreeNode* root, int height, int &m) {
        if(root == NULL) {
            m = max(m,height);
            return;
        }
        getheight(root->left,height+1,m);
        getheight(root->right,height+1,m);
    }
    
    void findsum(TreeNode* root,int &sum,int max,int height) {
        if(root == NULL) {
            return ;
        }
        findsum(root->left,sum,max,height+1);
        if(root->left == NULL and root->right == NULL and max-1 == height) {
            sum += root->val;
        }
        findsum(root->right,sum,max,height+1);
    }
    
    
    int deepestLeavesSum(TreeNode* root) {
        int max = 0,sum = 0;
        getheight(root,0,max);
        findsum(root,sum,max,0);
        
        return sum;
    }
};