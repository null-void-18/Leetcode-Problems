class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];

        for(char row[]: board) {
            Arrays.fill(row,'.');
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();

        backtrack(0,n,cols,diag1,diag2,board,ans);

        return ans;
    }


    public void backtrack(int row,int n,Set<Integer> cols,Set<Integer> diag1,Set<Integer> diag2,char board[][],List<List<String>> ans) {
        if(row == n) {
            ans.add(new ArrayList<>(construct(board)));
            return;
        }

        for(int i = 0;i < n;i++) {
            if(cols.contains(i) || diag1.contains(row + i) || diag2.contains(row-i)) {
                continue;
            }

            board[row][i] = 'Q';
            cols.add(i);
            diag1.add(row+i);
            diag2.add(row-i);
            backtrack(row+1,n,cols,diag1,diag2,board,ans);
            board[row][i] = '.';
            cols.remove(i);
            diag1.remove(row+i);
            diag2.remove(row-i);
        }
    }


    public List<String> construct(char[][] board) {
        List<String> ans = new ArrayList<>();
        for(char row[]: board) {
            ans.add(new String(row));
        }
        return ans;
    }
}
