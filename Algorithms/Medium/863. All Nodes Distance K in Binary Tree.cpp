
class Solution {
public:
    vector<int> ans;
    TreeNode* p;
    int k;
    
    void subtree(TreeNode* root,int n){
        if(!root) return;
        if(n==k){
            ans.push_back(root->val);
            return;
        }
        subtree(root->left,n+1);
        subtree(root->right,n+1);
        return;
    }
    
    int dfs(TreeNode* root){
        if(!root) return -1;
        else if(root == p){
            subtree(root,0);
            return 1;
        }
        else{
            int l=dfs(root->left),r=dfs(root->right);
            if(l!=-1){
                if(l==k) ans.push_back(root->val);
                else subtree(root->right,l+1);
                return l+1;
            }
            else if(r!=-1){
                if(r == k) ans.push_back(root->val);
                else subtree(root->left,r+1);
                return r+1;
            }
            else{
                return -1;
            }
        }
    }
    
    vector<int> distanceK(TreeNode* root, TreeNode* target, int K) {
        p=target;
        k=K;
        dfs(root);
        return ans;
    }
};
