
/* A Binary Tree node

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    
    void dfs(Node root,ArrayList<Integer> ans) {
        if(root == null) {
            return;
        }
        dfs(root.left,ans);
        ans.add(root.data);
        dfs(root.right,ans);
    }
    
    
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        dfs(root,ans);
        return ans;
    }
}
