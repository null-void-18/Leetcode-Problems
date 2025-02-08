//Recursive approach
class Solution {
    
    void dfs(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans,boolean vis[],int start) {
        if(vis[start]) {
            return;
        }
        vis[start] = true;
        ans.add(start);
        for(int i : adj.get(start)) {
            if(!vis[i]) {
                dfs(adj,ans,vis,i);
            }
        }
    }
     
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        boolean vis[] = new boolean[adj.size()];
        dfs(adj,ans,vis,0);
        return ans;
    }
}





//Iterative approach
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
