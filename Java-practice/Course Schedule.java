
//Topo sort, Kahn's algo

class Solution {
    public static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        int[] indegree = new int[n];
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : prerequisites) {
            int course = edge.get(0);
            int prereq = edge.get(1);
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        if (order.size() != n) {
            return new int[0];
        }

        return order.stream().mapToInt(i -> i).toArray();
    }
}
