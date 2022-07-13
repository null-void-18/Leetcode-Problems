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
    
    TreeNode* createtree(vector<int> &nums,int i,int j) {
        if(i > j) {
            return nullptr;
        }
        int max = 0,mid = i;
        for(int index = i; index <= j; index++) {
            if(nums[index] > max) {
                max = nums[index];
                mid = index;
            }
        }
        TreeNode* root = new TreeNode(nums[mid]);
        //cout<<root->val<<endl;
        root->left = createtree(nums,i,mid-1);
        root->right = createtree(nums,mid+1,j);
        return root;
    }
    
    
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        
        
        
        return createtree(nums,0,nums.size()-1);
    }
};