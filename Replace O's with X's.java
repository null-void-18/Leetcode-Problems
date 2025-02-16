
//BFS Approach

class Solution {
    
    static void markBorderConnected(char[][] ans, int i, int j, int m, int n) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        ans[i][j] = '#'; 

        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int row = pair[0], col = pair[1];

            for (int k = 0; k < 4; k++) {
                int x = dx[k] + row;
                int y = dy[k] + col;

                if (x >= 0 && y >= 0 && x < m && y < n && ans[x][y] == 'O') {
                    q.add(new int[]{x, y});
                    ans[x][y] = '#'; 
                }
            }
        }
    }

    static char[][] fill(char mat[][]) {
        int m = mat.length;
        int n = mat[0].length;

        char ans[][] = new char[m][n];
        for (int i = 0; i < m; i++) {
            ans[i] = mat[i].clone();
        }

        for (int i = 0; i < m; i++) {
            if (ans[i][0] == 'O') markBorderConnected(ans, i, 0, m, n);
            if (ans[i][n - 1] == 'O') markBorderConnected(ans, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            if (ans[0][j] == 'O') markBorderConnected(ans, 0, j, m, n);
            if (ans[m - 1][j] == 'O') markBorderConnected(ans, m - 1, j, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 'O') {
                    ans[i][j] = 'X'; 
                } else if (ans[i][j] == '#') {
                    ans[i][j] = 'O'; 
                }
            }
        }

        return ans;
    }

}
