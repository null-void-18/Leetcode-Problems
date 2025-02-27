
//DFS Approach

class Solution {
    
    boolean dfs(List<List<Integer>> adj, int start, boolean[] vis, boolean[] pathVis, boolean[] safe) {
        vis[start] = true;
        pathVis[start] = true; 
        
        for (int node : adj.get(start)) {
            if (!vis[node]) { 
                if (!dfs(adj, node, vis, pathVis, safe)) {
                    return false; 
                }
            } else if (pathVis[node]) { 
                return false;
            }
        }
        
        pathVis[start] = false; 
        safe[start] = true; 
        return true;
    }
    
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V]; 
        boolean[] safe = new boolean[V]; 
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis, pathVis, safe);
            }
        }
        
        for (int i = 0; i < V; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }
        
        return ans;
    }
}
