
//DFS Approach

class Solution {
    
    void dfs(ArrayList<ArrayList<Integer>> adj,int color[],int start,int prevColor,boolean[] flag) {
        for(int i : adj.get(start)) {
            if(color[i] == -1) {
                color[i] = 1 - prevColor;
                dfs(adj,color,i,1-prevColor,flag);
            }else if(color[i] == prevColor) {
                flag[0] = false;
            }
        }
    }
    
    
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int color[] = new int[n];
        boolean[] flag = {true};
        Arrays.fill(color, -1);
        for(int i = 0; i < n;i++) {
            if(color[i] == -1) {
                color[i] = 0;
                dfs(adj,color,i,0,flag);
            }
        }
        return flag[0];
    }
}


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
