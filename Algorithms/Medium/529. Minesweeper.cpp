class Solution {
public:
    vector<int> io = {0,-1,-1,-1,0,1,1,1}, jo = {-1,-1,0,1,1,1,0,-1};
    int adj_mines(vector<vector<char>>& board, int i, int j) {
        int count = 0;
        for(int k=0; k<8; k++) {
            int r = i + io[k];
            int c = j + jo[k];
            if(r<0 || c<0 || r>=board.size() || c>=board[0].size())
                continue;
            if(board[r][c]=='M')
                count++;
        }
        return count;
    }
    void dfs(vector<vector<char>>& board, int i, int j) {
        if(i<0 || j <0 || i>=board.size() || j>=board[0].size())
            return;
        int count = adj_mines(board,i,j);
        if(!count) {
            board[i][j] = 'B';
            for(int k=0; k<8; k++) {
                int r = i + io[k];
                int c = j + jo[k];
                if(r<0 || c<0 || r>=board.size() || c>=board[0].size() || board[r][c]!='E')
                    continue;
                dfs(board,r,c);
            }
            return;
        }
        else {
            board[i][j] = '0' + count;
            return;
        }
    }

    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        char& ch = board[click[0]][click[1]];
        if(ch=='M') ch = 'X';
        else if(ch=='E') dfs(board,click[0],click[1]);
        return board;
    }
};
