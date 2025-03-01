

//BFS Approach

class Solution {
    class Pair {
        int vertex, weight;
        Pair(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
    }

    public int[] shortestPath(int N, int E,int[][] edges) {
        int source = 0;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        int[] indegree = new int[N];
        for (int i = 0; i < N; i++) {
            for (Pair neighbor : adj.get(i)) {
                indegree[neighbor.vertex]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);
            for (Pair neighbor : adj.get(node)) {
                indegree[neighbor.vertex]--;
                if (indegree[neighbor.vertex] == 0) {
                    queue.add(neighbor.vertex);
                }
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int node : topoOrder) {
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair neighbor : adj.get(node)) {
                    int newDist = dist[node] + neighbor.weight;
                    if (newDist < dist[neighbor.vertex]) {
                        dist[neighbor.vertex] = newDist;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
