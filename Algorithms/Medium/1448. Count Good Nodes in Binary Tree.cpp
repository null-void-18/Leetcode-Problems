class Solution {
public:
    void traverse(TreeNode *root, int &count, int currMax)
    {
        if(!root) return;
        count += (currMax <= root->val) ? 1 : 0;
        currMax = max(root->val, currMax);    
        traverse(root->left, count, currMax);
        traverse(root->right, count, currMax);
    }
    
    int goodNodes(TreeNode* root) 
    {
        int count = 0;
        traverse(root, count, INT_MIN);
        return count;
    }
};
