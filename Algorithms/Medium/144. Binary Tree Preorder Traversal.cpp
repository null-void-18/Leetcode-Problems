Iterative Solution:

class Solution {
public:   
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> a;
        while(root!=NULL || !a.empty()){
            while(root!=NULL){
                res.push_back(root->val);
                a.push(root);
                root=root->left;
            }
            root=a.top();
            a.pop();
            root=root->right;
        }
        return res;
    }
};



Recursive Solution:

class Solution {
public:
    vector<int> res;
    vector<int> preorderTraversal(TreeNode* root) {
        if(root == NULL) return res;
        res.push_back(root->val);
        preorderTraversal(root->left);
        preorderTraversal(root->right);
        
        return res;
    }
};
