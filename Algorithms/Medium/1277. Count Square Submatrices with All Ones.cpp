class Solution
{
public:
    int countSquares(vector<vector<int>> &matrix)
    {
        int m = matrix.size(), n = matrix[0].size();
        if(m == 0)
        return 0;

        int dp[m][n];

        for (int i = 0; i < n; i++)
            dp[0][i] = matrix[0][i];

        for (int i = 1; i < m; i++)
            dp[i][0] = matrix[i][0];

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if(matrix[i][j] == 1)
                dp[i][j] = 1 + min(dp[i-1][j-1], min(dp[i][j-1], dp[i-1][j]));
                else
                dp[i][j] = 0;
            }   
        }

        int result = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                result += dp[i][j];
        
        return result;
    }
};
