
//Depth First Search using stack

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        boolean vis[] = new boolean[adj.size()];
        
        stack.push(0);
        
        while(!stack.isEmpty()) {
            int value = stack.pop();
            
            if(!vis[value]) {
                vis[value] = true;
                ans.add(value);
                
                Collections.reverse(adj.get(value));
                
                for(int i : adj.get(value)) {
                    stack.push(i);
                }
            }
        }
        return ans;
    }
}
