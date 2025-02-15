//Number of Provinces

//BFS Converted to adj list --> Optimal Solution


class Solution {
    
    static ArrayList<ArrayList<Integer>> convertMatrixToList(ArrayList<ArrayList<Integer>> matrix, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < V; j++) {
                if (matrix.get(i).get(j) == 1 && i != j) {  
                    adjList.get(i).add(j);
                }
            }
        }
        return adjList;
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adjMatrix, int V) {
        boolean vis[] = new boolean[V];
        int provinces = 0;
        ArrayList<ArrayList<Integer>> adj = convertMatrixToList(adjMatrix, V);
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                provinces += 1;
                q.add(i);
                vis[i] = true;
                
                while(!q.isEmpty()) {
                    int front = q.remove();
                    
                    for(int k : adj.get(front)) {
                        if(!vis[k]) {
                            q.add(k);
                            vis[k] = true;
                        }
                    }
                }
            }
        }
        return provinces;
    }
};







//DFS Converted to adj list --> Optimal Solution

class Solution {
    
    static void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int start) {
        if(vis[start]) return;
        
        vis[start] = true;
        
        
        for(Integer i : adj.get(start)) {
            if(!vis[i]) {
                dfs(adj,vis,i);
            }
        }
    }
    
    static ArrayList<ArrayList<Integer>> convertMatrixToList(ArrayList<ArrayList<Integer>> matrix, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < V; j++) {
                if (matrix.get(i).get(j) == 1 && i != j) {  
                    adjList.get(i).add(j);
                }
            }
        }
        return adjList;
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adjMatrix, int V) {
        boolean vis[] = new boolean[V];
        int provinces = 0;
        ArrayList<ArrayList<Integer>> adj = convertMatrixToList(adjMatrix, V);
        
        for(int i =0; i < V;i++) {
            if(!vis[i]) {
                provinces += 1;
                dfs(adj,vis,i);
            }
        }
        return provinces;
    }
};








//My first submission


class Solution {
    
    static void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int start,int V) {
        if(vis[start]) return;
        
        vis[start] = true;
        
        for(int j = 0; j < V; j++) {
            if(start == j) {
              continue;
            }
            if(adj.get(start).get(j) == 1) {
                dfs(adj,vis,j,V);
            }
        }
    }
    
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean vis[] = new boolean[V];
        int provinces = 0;
        
        for(int i =0; i < V;i++) {
            if(!vis[i]) {
                provinces += 1;
                dfs(adj,vis,i,V);
            }
        }
        
        
        return provinces;
    }
};
