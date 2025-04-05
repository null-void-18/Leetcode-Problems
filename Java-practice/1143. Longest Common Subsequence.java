
//DP Approach

class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
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
        return dp[m][n];
    }

}




//Recursion with Memoization


class Solution {

    int calculate(int m,int n,String text1,String text2,int dp[][]) {
        if(n < 0 || m < 0) return 0;

        if(dp[m][n] != -1) return dp[m][n];

        if(text1.charAt(m) == text2.charAt(n)) {
            return 1 + (calculate(m-1,n-1,text1,text2,dp));
        }

        return dp[m][n] = Math.max(calculate(m-1,n,text1,text2,dp),calculate(m,n-1,text1,text2,dp));
    }


    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int dp[][] = new int[m][n];

        for(int row[] : dp) {
            Arrays.fill(row,-1);
        }

        return calculate(m-1,n-1,text1,text2,dp);
    }
}
