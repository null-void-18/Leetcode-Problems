//BFS approach


class Solution {
    
    static void bfs(char[][] grid, int i, int j, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = '0'; 
        
        int[] dx = {-1,  1,  0,  0,  -1, -1,  1,  1};  
        int[] dy = { 0,  0, -1,  1,  -1,  1, -1,  1};  

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];

            for (int d = 0; d < 8; d++) {
                int newX = x + dx[d];
                int newY = y + dy[d];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == '1') {
                    grid[newX][newY] = '0'; 
                    q.add(new int[]{newX, newY});
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    bfs(grid, i, j, m, n);
                }
            }
        }
        return islands;
    }
}


//DFS approach


class Solution {
    
    static void dfs(char grid[][], int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        
        grid[i][j] = '0'; 
        
        int[] dx = {-1,  1,  0,  0,  -1, -1,  1,  1}; 
        int[] dy = { 0,  0, -1,  1,  -1,  1, -1,  1};

        
        for (int d = 0; d < 8; d++) {
            dfs(grid, i + dx[d], j + dy[d], m, n);
        }
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return islands;
    }
}
