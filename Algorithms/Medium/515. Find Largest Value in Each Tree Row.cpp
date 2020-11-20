//OPTIMAL SOLUTION

class Solution {
public:
    int height(TreeNode* p){
        if(p == NULL) return 0;
        return 1+max(height(p->left),height(p->right));
    }
    
    void dfs(TreeNode* p,vector<int> &ans,int n){
        if(p == NULL) return;
        ans[n-1]=max(ans[n-1],p->val);
        dfs(p->left,ans,n+1);
        dfs(p->right,ans,n+1);
        return;
    }
    
    vector<int> largestValues(TreeNode* root) {
        int d=height(root);
        if(root == NULL) return {};
        vector<int> ans(d,INT_MIN);
        dfs(root,ans,1);
        return ans;
    }
};


//EASY SOLUTION TO UNDERSTAND
//O(N^2) SOLUTION

class Solution {
public:
    int height(TreeNode* p){
        if(p == NULL) return 0;
        return 1+max(height(p->left),height(p->right));
    }
    
    void dfs(TreeNode* p,vector<int> &temp,int d,int n){
        if(p == NULL) return;
        if(n==d) temp.push_back(p->val);
        dfs(p->left,temp,d,n+1);
        dfs(p->right,temp,d,n+1);
        return;
    }
    
    vector<int> largestValues(TreeNode* root) {
        int d=height(root);
        if(root == NULL) return {};
        vector<int> ans,temp;
        ans.push_back(root->val);
        for(int i=2;i<=d;i++){
            dfs(root,temp,i,1);
            ans.push_back(*max_element(temp.begin(),temp.end()));
            temp.clear();
        }
        return ans;
    }
};
