//DFS Approach


class Solution {
    static class Pair {
        int vertex, weight;
        Pair(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
    }

    public int[] shortestPath(int N,int E, int[][] edges) {
        int source = 0;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topoSort(i, visited, stack, adj);
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
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

    private void topoSort(int node, boolean[] visited, Stack<Integer> stack, List<List<Pair>> adj) {
        visited[node] = true;
        for (Pair neighbor : adj.get(node)) {
            if (!visited[neighbor.vertex]) {
                topoSort(neighbor.vertex, visited, stack, adj);
            }
        }
        stack.push(node);
    }
}





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
