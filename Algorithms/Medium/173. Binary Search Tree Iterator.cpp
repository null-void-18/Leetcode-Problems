class BSTIterator {
public:
    stack<TreeNode*> nodes;
    BSTIterator(TreeNode* root) {
        while(root){
            nodes.push(root);
            root=root->left;
        }
    }
    
    int next() {
        TreeNode *ans=nodes.top(),*curr=nodes.top()->right;
        nodes.pop();
        while(curr){
            nodes.push(curr);
            curr=curr->left;
        }
        return ans->val;
    }
    
    bool hasNext() {
        return nodes.empty()==0;
    }
};
