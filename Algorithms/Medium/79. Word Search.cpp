class Solution {
public:
    bool btrack(vector<vector<char>>& board, string word, int start, int i, int j)
    {
        if (start == word.size()) {
            return true;
        }
        if (   i < 0 || i >= board.size() 
            || j < 0 || j >= board[0].size()
            || board[i][j] != word[start]) {
            return false;
        }
        
        board[i][j] = '\0';
        bool matched =     btrack(board, word, start+1, i+1, j)
                        || btrack(board, word, start+1, i, j+1)
                        || btrack(board, word, start+1, i-1, j)
                        || btrack(board, word, start+1, i, j-1);
        board[i][j] = word[start];
        return matched;
    }
    
    bool exist(vector<vector<char>>& board, string word) 
    {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                if ( btrack(board, word, 0, i, j) ) {
                    return true;
                }
            }
        }
        return false;
    }
};
