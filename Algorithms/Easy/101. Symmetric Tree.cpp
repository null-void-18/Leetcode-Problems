class Solution {
public:
    bool is(TreeNode* p,TreeNode* q){
        if(p==NULL and q==NULL) return true;
        if(p==NULL || q==NULL) return false;
        return ((p->val == q->val) and is(p->left,q->right) and is(p->right,q->left));
    }
    
    
    bool isSymmetric(TreeNode* root) {
        return is(root,root);        
    }
};
