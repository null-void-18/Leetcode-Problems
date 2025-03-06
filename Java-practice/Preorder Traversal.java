
//Back-end complete function Template for Java
class Solution {
    
    static void dfs(Node root,ArrayList<Integer> ans) {
        if(root == null) return;
        ans.add(root.data);
        dfs(root.left,ans);
        dfs(root.right,ans);
    }
    
    
    // Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        dfs(root,ans);
        return ans;
    }
}
