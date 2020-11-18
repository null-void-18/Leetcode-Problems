class Solution {
public:
    int height(TreeNode* p){
        if(p == NULL) return 0;
        return 1+max(height(p->left),height(p->right));
    }

    void sum(TreeNode* p,int n,int l,int &s){
        if(p==NULL) return;
        if(n==l) s+=p->val;
        sum(p->left,n,l+1,s);
        sum(p->right,n,l+1,s);
        return;
    }
    
    int deepestLeavesSum(TreeNode* root) {
        int n=height(root);
        int s=0;
        sum(root,n,1,s);
        return s;
    }
};
