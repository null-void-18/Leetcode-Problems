class Solution {
public:
    int dfs(TreeNode* p){
        if(p==NULL) return 0;
        return 1+max(dfs(p->left),dfs(p->right));
    }
    
    void leftmost(TreeNode* p,int &flag,int &val,int n,int d){
        if(p == NULL) return ;
        if(n==d and !flag){
            flag=1;
            val=p->val;
            return ;
        }            
        leftmost(p->left,flag,val,n+1,d);
        leftmost(p->right,flag,val,n+1,d);
        return;
    }
    
    int findBottomLeftValue(TreeNode* root) {
        int flag=0,val=0;
        int depth=dfs(root);
        if(root == NULL) return 0;
        leftmost(root,flag,val,1,depth);
        return val;
    }
};
