//DP Approach

class Solution {

    public int minInsertions(String text1) {
        int m = text1.length();

        String text2 = "";
        for (int i = 0; i < text1.length(); i++) {
        text2 = text1.charAt(i) + text2;
        }

        int n = text2.length();

        int dp[][] = new int[m + 1][n + 1]; 

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; 
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; 
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 
                }
            }
        }
        return m - dp[m][n];
    }
}
