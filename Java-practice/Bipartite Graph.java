

//BFS Approach


class Solution {
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int color[] = new int[n]; // Color array: -1 (unvisited), 0, 1
        Arrays.fill(color, -1); 
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int start = 0; start < n; start++) {
            if (color[start] != -1) continue; // Already visited
            
            q.add(start);
            color[start] = 0; // Start coloring with 0
            
            while (!q.isEmpty()) {
                int node = q.poll();
                
                for (int neighbor : adj.get(node)) {
                    if (color[neighbor] == -1) { // If unvisited, assign opposite color
                        color[neighbor] = 1 - color[node];
                        q.add(neighbor);
                    } 
                    else if (color[neighbor] == color[node]) { // Conflict detected
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
