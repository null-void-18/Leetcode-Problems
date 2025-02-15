
//BFS approach


class Solution {
    
    
    static void bfs(int[][] image,int sr,int sc,int m,int n,int newColor,int prevColor) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = newColor;
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        
        while(!q.isEmpty()) {
            int[] poll = q.remove();
            
            
            for(int i = 0;i < 4;i++) {
                int x = poll[0] + dx[i];
                int y = poll[1] + dy[i];
                if(x >= 0 && x < m && y >= 0 && y < n && image[x][y] == prevColor) {
                    q.add(new int[]{x,y});
                    image[x][y] = newColor;
                }
            }
        }
    }
    
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if(image[sr][sc] == newColor) return image;
        bfs(image,sr,sc,m,n,newColor,image[sr][sc]);
        return image;
    }
}







//DFS approach

class Solution {
    
    static void dfs(int[][] image,int sr,int sc,int m,int n,int newColor,int prevColor) {
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != prevColor) return;
        if(image[sr][sc] == newColor) return;
        image[sr][sc] = newColor;
        
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        
        for(int i = 0; i < 4;i++) {
            dfs(image,sr + dx[i], sc + dy[i], m, n, newColor,prevColor);
        }
        
    }
    
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if(image[sr][sc] == newColor) return image;
        dfs(image,sr,sc,m,n,newColor,image[sr][sc]);
        return image;
    }
}
