class Solution {
    public void solveSudoku(char[][] board) {
        sudoko(board);
    }

    public boolean sudoko(char[][] board) {
        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;j++) {
                if(board[i][j] == '.') {
                    for(char k = '1';k <= '9';k++) {
                        if(isValid(board,i,j,k)) {
                            board[i][j] = k;
                            if (sudoko(board)) return true; 
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board,int row,int col,int num) {
        for(int i = 0;i < 9;i++) {
            if(board[row][i] == num) return false;
            if(board[i][col] == num) return false;
            if(board[3 * (row/3) + (i/3)][3 * (col/3) + (i%3)] == num) {
                return false;
            }
        }
        return true;
    }

}
