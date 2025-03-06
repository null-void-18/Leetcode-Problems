
class Solution {
    
    void dfs(Node root,ArrayList<Integer> ans) {
        if(root == null) return;
        dfs(root.left,ans);
        dfs(root.right,ans);
        ans.add(root.data);
    }
    
    
    // Function to return a list containing the preorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        dfs(root,ans);
        return ans;
    }
}
