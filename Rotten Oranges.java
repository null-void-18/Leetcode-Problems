//BFS Approach


class Solution {
    public int orangesRotting(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int count = 0;
        int fresh = 0;  
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    fresh++;  
                }
            }
        }

        if (fresh == 0) return 0;  

        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] arr = q.remove();

                for (int k = 0; k < 4; k++) {
                    int x = dx[k] + arr[0];
                    int y = dy[k] + arr[1];

                    if (x >= 0 && y >= 0 && x < m && y < n && mat[x][y] == 1) {
                        mat[x][y] = 2;
                        q.add(new int[]{x, y});
                        fresh--;  
                    }
                }
            }
        }

        return fresh == 0 ? count - 1 : -1;
    }
}
