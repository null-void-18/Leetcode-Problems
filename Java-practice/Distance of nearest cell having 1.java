



//BFS approach

class Solution
{
    public int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            step++;

            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];

                for (int k = 0; k < 4; k++) {
                    int newX = x + dx[k];
                    int newY = y + dy[k];

                    if (newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        ans[newX][newY] = step;
                        q.add(new int[]{newX, newY});
                    }
                }
            }
        }

        return ans;
    }
}
