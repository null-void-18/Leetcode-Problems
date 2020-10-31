Iterative Solution:

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> a;
        
        while(root!=NULL || !a.empty()){
            
            while(root!=NULL){
                a.push(root);
                root=root->left;
            }
            
            root=a.top();
            a.pop();
            res.push_back(root->val);
            root=root->right;
        }
        return res;
    }
};



Recursive Solution:

class Solution {
public:

    vector<int> a;
    
    vector<int> inorderTraversal(TreeNode* root) {
        if(root == NULL){
            return a;
        }
        else{
            inorderTraversal(root->left);
            a.push_back(root->val);
            inorderTraversal(root->right);
        }
        return a;
    }
};

