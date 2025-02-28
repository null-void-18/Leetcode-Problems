
//Topo sort, Kahn's algo - Course Schedule II 

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





//Course Schedule I - Leetcode - DFS Cycle detection

class Solution {

    private boolean dfs(List<List<Integer>> adj,boolean vis[],boolean rec[],int start) {
        vis[start] = true;
        rec[start] = true;

        for(int i : adj.get(start)) {
            if(!vis[i]) {
                if(dfs(adj,vis,rec,i)) {
                    return true; 
                }
            }else if(rec[i] == true) {
                return true;
            }
        }
        rec[start] = false;
        return false;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];
        for(int i = 0; i < numCourses;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] it : prerequisites) {
            adj.get(it[1]).add(it[0]);
        }

        for(int i = 0; i < numCourses;i++) {
            if(!vis[i]) {
                if(dfs(adj,vis,rec,i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
