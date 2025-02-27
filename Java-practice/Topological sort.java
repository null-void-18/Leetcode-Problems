
//DFS Approach


class Solution {
    
    
    static void dfs(ArrayList<ArrayList<Integer>> adj,Stack<Integer> s,boolean vis[],int start,int V) {
        vis[start] = true;
        
        for(int i : adj.get(start)) {
            if(!vis[i]) {
                dfs(adj,s,vis,i,V);
            }
        }
        s.push(start);
    }
    
    
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean vis[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0;i < V;i++) {
            if(!vis[i]) {
                dfs(adj,s,vis,i,V);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!s.isEmpty()) {
            ans.add(s.pop());
        }
        return ans;
    }
}
