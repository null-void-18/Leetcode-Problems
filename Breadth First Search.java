
//Breadth First Search

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        vis[0] = 1;
        ans.add(0);
        while(queue.size() != 0) {
            int value = queue.remove();
            
            for(int i = 0;i < adj.get(value).size();i++) {
                if(vis[adj.get(value).get(i)] != 1) {
                    queue.add(adj.get(value).get(i));
                    ans.add(adj.get(value).get(i));
                    vis[adj.get(value).get(i)] = 1;
                }
            }
        }
        return ans;
    }
}
