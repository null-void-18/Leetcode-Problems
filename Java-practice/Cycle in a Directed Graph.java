



//DFS approach


class Solution {
    
    
    boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean recStack[], int i) {
        vis[i] = true;
        recStack[i] = true; 
        
        for (int neighbor : adj.get(i)) {
            if (!vis[neighbor]) { 
                if (dfs(adj, vis, recStack, neighbor)) {
                    return true;
                }
            } else if (recStack[neighbor]) { 
                return true;
            }
        }
        
        recStack[i] = false; 
        return false;
    }
    
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean vis[] = new boolean[V];
        boolean recStack[] = new boolean[V]; 
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(adj, vis, recStack, i)) {
                    return true; 
                }
            }
        }
        return false;
    }
}
