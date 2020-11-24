class Solution {
    vector<TreeNode*> nodes;
    void util(TreeNode* root) {
        if(!root) return;
        if(root->left) util(root->left);
        nodes.push_back(root);
        if(root->right) util(root->right);
    }
    TreeNode* construct(int l, int r) {
        if(l>=r) return NULL;
        int mid = l + (r-l)/2;
        auto node = nodes[mid];
        node->left = construct(l,mid), node->right = construct(mid+1,r);
        return node;
    }
public:
    TreeNode* balanceBST(TreeNode* root) {
        util(root);
        return construct(0,nodes.size());
    }
};
