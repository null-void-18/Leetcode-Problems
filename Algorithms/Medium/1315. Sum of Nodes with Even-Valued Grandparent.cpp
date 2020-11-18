class Solution {
public:
    int sumEvenGrandparent(TreeNode* root) {
        if(root == NULL) return 0;
        int ans=0;
        if(root->val%2 == 0){
            if(root->left!=NULL){
                if(root->left->left!=NULL) ans+=root->left->left->val;
                if(root->left->right!=NULL) ans+=root->left->right->val;
            }
            if(root->right!=NULL){
                if(root->right->left!=NULL) ans+=root->right->left->val;
                if(root->right->right!=NULL) ans+=root->right->right->val;
            }
        }
        ans+=sumEvenGrandparent(root->left)+sumEvenGrandparent(root->right);
        return ans;
    }
};
