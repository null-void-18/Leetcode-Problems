
class Solution {
    
    boolean isValid(List<List<Integer>> adj, int[] color, int node, int c) {
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == c) {
                return false;
            }
        }
        return true;
    }
    
    boolean colorGraph(List<List<Integer>> adj, int[] color, int v, int m, int node) {
        if (node == v) {
            return true;
        }
        
        for (int c = 1; c <= m; c++) {
            if (isValid(adj, color, node, c)) {
                color[node] = c;
                
                if (colorGraph(adj, color, v, m, node + 1)) {
                    return true;
                }
                
                color[node] = -1; 
            }
        }
        return false;
    }
    
    boolean graphColoring(int v, List<int[]> edges, int m) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] color = new int[v];
        Arrays.fill(color, -1);
        
        return colorGraph(adj, color, v, m, 0);
    }
}
