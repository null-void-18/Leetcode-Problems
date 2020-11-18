class Solution {
public:
    vector<int> a;
    
    void inorder(TreeNode* p){
        if(p==NULL) return;
        inorder(p->left);
        a.push_back(p->val);
        inorder(p->right);
        return;
    }
    
    TreeNode* increasingBST(TreeNode* root) {
        inorder(root);
        TreeNode* r,*c;
        r=new TreeNode(a[0]);
        c=r;
        for(int x=1;x<a.size();x++){
            r->right=new TreeNode(a[x]);
            r=r->right;
        }
        return c;
    }
};
