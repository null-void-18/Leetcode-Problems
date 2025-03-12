
class Solution {
    
    void backtrack(int i, int j, int n, StringBuilder s, boolean[][] vis,
                   ArrayList<String> ans, ArrayList<ArrayList<Integer>> mat) {
        
        if (i == n - 1 && j == n - 1) {
            ans.add(s.toString());
            return;
        }

        if (i < 0 || j < 0 || i >= n || j >= n || mat.get(i).get(j) != 1 || vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        if (i + 1 < n && !vis[i + 1][j]) {
            s.append("D");
            backtrack(i + 1, j, n, s, vis, ans, mat);
            s.deleteCharAt(s.length() - 1);
        }

        if (j - 1 >= 0 && !vis[i][j - 1]) {
            s.append("L");
            backtrack(i, j - 1, n, s, vis, ans, mat);
            s.deleteCharAt(s.length() - 1);
        }

        if (j + 1 < n && !vis[i][j + 1]) {
            s.append("R");
            backtrack(i, j + 1, n, s, vis, ans, mat);
            s.deleteCharAt(s.length() - 1);
        }

        if (i - 1 >= 0 && !vis[i - 1][j]) {
            s.append("U");
            backtrack(i - 1, j, n, s, vis, ans, mat);
            s.deleteCharAt(s.length() - 1);
        }

        vis[i][j] = false;
    }

    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.size();
        
        if (n == 0 || mat.get(0).get(0) == 0 || mat.get(n - 1).get(n - 1) == 0) {
            return ans;
        }

        boolean[][] vis = new boolean[n][n];
        backtrack(0, 0, n, new StringBuilder(), vis, ans, mat);
        
        return ans;
    }
}
