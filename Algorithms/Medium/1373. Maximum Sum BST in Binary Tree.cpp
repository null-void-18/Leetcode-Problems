class Solution {
public:
bool check(TreeNode* root,int& gmin,int& gmax,int& sum,int& maxsum){
    if(root==NULL)
        return true;
    
    int lsum=0,lmin =INT_MAX, lmax = INT_MIN;
    bool lbst = check(root->left,lmin,lmax,lsum,maxsum);
    
    int rsum=0,rmin =INT_MAX, rmax = INT_MIN;
    bool rbst = check(root->right,rmin,rmax,rsum,maxsum);
    
    if(lbst && rbst && lmax<root->val && rmin>root->val){
        sum = lsum + rsum + root->val;
        maxsum = max(maxsum,sum);
        
        gmin = min(lmin,root->val);
        gmax = max(rmax,root->val);
        return true;
    }
    
    return false;    
}
    int maxSumBST(TreeNode* root) {
        int sum = 0, maxsum = 0, gmin = INT_MAX, gmax = INT_MIN;
        check(root,gmin,gmax,sum,maxsum);
        return maxsum;
    }
};
