class Solution {
    int max_depth;
    TreeNode *subtree;
    
    int postorder(TreeNode *node, int depth) {
        
        if(node == NULL)
            return depth - 1;
        
        int left, right;
        
        left = postorder(node->left, depth + 1);
        right = postorder(node->right, depth + 1);
        
        /* left == right can happen in two cases
            1. Leaf Node
            2. Node with equal depth on both left and right sides
        */
        if(left == right) {
            //if leaf Node, see if we reached a new max depth
            if(left > max_depth) {
                max_depth = left;
            }   
            
            //if both childs are max depth, this is smallest subtree
            if(left == max_depth)
                subtree = node;
        }

        return left > right ? left : right;
    }
	
public:
    TreeNode* subtreeWithAllDeepest(TreeNode* root) {
        max_depth = 0;
        subtree = NULL;
        postorder(root,  1);
       
        return subtree;
        
    }
};
