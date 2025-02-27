

//Topo sort


class Solution {
    
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        
        // Calculate indegrees
        for (int i = 0; i < V; i++) {
            for (int node : adj.get(i)) {
                indegree[node]++;
            }
        }
        
        // Add nodes with 0 indegree to the queue
        int count = 0;  // Tracks number of processed nodes
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                count++;  // Increment count instead of storing in ans list
            }
        }
        
        // BFS (Kahn's Algorithm)
        while (!q.isEmpty()) {
            int node = q.poll();
            
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                    count++;  // Increment count when processing a node
                }
            }
        }
        
        // If count < V, then a cycle exists
        return count != V;
    }
}




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
