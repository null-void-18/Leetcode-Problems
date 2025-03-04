
/*
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
*/
class Solution {
    
    class AdjNode {
        int v;
        int w;
        
        AdjNode(int vertex,int weight) {
            v = vertex;
            w = weight;
        }
    }
    
    
    
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int V = adj.size();
        int dis[] = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        
        PriorityQueue<AdjNode> pq = new PriorityQueue<>((v1,v2) -> (v1.w - v2.w));
        
        pq.add(new AdjNode(src,0));
        dis[src] = 0;
        while(!pq.isEmpty()) {
            AdjNode node = pq.poll();
            
            for(iPair n : adj.get(node.v)) {
                if(dis[n.first] > dis[node.v] + n.second) {
                    dis[n.first] = dis[node.v] + n.second;
                    pq.add(new AdjNode(n.first,dis[n.first]));
                }
            }
            
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : dis) {
            ans.add(num); 
        }
        return ans;
    }   
}
