//BFS Approach


class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size();
        int ans[] = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE); 

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        ans[src] = 0; 

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj.get(node)) {
                if (ans[neighbor] == Integer.MAX_VALUE) { 
                    ans[neighbor] = ans[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
