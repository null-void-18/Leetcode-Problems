class Solution {
public:
    TreeNode* bst(vector<int> nums,int start,int end){
        if(start>end) return NULL;
        if(start == end) return new TreeNode(nums[start]);
        int mid=(start+end)/2;
        TreeNode* node=new TreeNode(nums[mid]);
        node->left=bst(nums,start,mid-1);
        node->right=bst(nums,mid+1,end);
        return node;
    }
    
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return bst(nums,0,nums.size()-1);
    }
};
