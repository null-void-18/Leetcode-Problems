
//BFS approach


class Solution {
    
    static void bfs(int[][] grid, boolean[][] vis, Set<String> st, int i, int j, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        StringBuilder s = new StringBuilder();

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        int baseX = i, baseY = j;
        q.add(new int[]{i, j});
        vis[i][j] = true;
        
        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int row = pair[0], col = pair[1];

            s.append((row - baseX) + "," + (col - baseY) + " ");

            for (int k = 0; k < 4; k++) {
                int x = row + dx[k];
                int y = col + dy[k];

                if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1 && !vis[x][y]) {
                    vis[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }

        st.add(s.toString()); 
    }

    public int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        Set<String> s = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    bfs(grid, vis, s, i, j, m, n);
                }
            }
        }

        return s.size();
    }

}
