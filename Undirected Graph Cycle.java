//DFS approach


class Solution {
    static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int start, int parent) {
        vis[start] = true;

        for (int i : adj.get(start)) {
            if (!vis[i]) {
                if (dfs(adj, vis, i, start)) {
                    return true; 
                }
            } else if (i != parent) {
                return true; 
            }
        }
        return false;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(adj, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

//BFS Approach


class Solution {
    
    static boolean bfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,-1});
        vis[start] = true;
        
        while(!q.isEmpty()) {
            int pair[] = q.poll();
            int node = pair[0];
            int parent = pair[1];
            
            for(int i : adj.get(node)) {
                if(!vis[i]) {
                    q.add(new int[]{i,node});
                    vis[i] = true;
                }else if(i != parent) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean vis[] = new boolean[V];
        
        for(int i =0;i < V;i++) {
            if(!vis[i]) {
                if(bfs(adj,vis,i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
