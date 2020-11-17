class Solution {
public:
    int ans=0;
    
    void dfs(TreeNode* p,TreeNode* q){
        if(p == NULL && q == NULL) return;
        else if((p==NULL and q!=NULL) or (p!=NULL and q==NULL)){
            ans=1;
            return;
        }
        dfs(p->left,q->left);
        if(p->val != q->val){
            ans=1;
            return;
        }
        dfs(p->right,q->right);
    }
    
    bool isSameTree(TreeNode* p, TreeNode* q) {
        dfs(p,q);
        return ans==0;
    }
};
