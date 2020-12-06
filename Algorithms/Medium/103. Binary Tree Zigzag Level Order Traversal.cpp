class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root)
    {
        vector<vector<int>> ans;
        vector<int> v;
        int count=1;
        bool level=false;
        
        if(root==NULL)
            return ans;
        
        queue<TreeNode*>q;
        q.push(root);
        
        while(!q.empty()) {
            root= q.front();
            v.push_back(root->val);
            q.pop();
            count--;
            
            if(root->left)
                q.push(root->left);
            if(root->right)
                q.push(root->right);
            
            if(count==0) {
                count= q.size();
                if(level==true) {
                    reverse(v.begin(), v.end());
                }
                level= !level;;
                ans.push_back(v);
                v.clear();
            }
        }
        
        return ans;
        
    }
};
