
//LCS Optimal Solution


public class Solution {
    private static String printLcs(int m,int n,String text1,int dp[][]) {
        if(m == 0 || n == 0) {
            return "";
        }
        
        if(dp[m][n] == dp[m-1][n]) {
            return printLcs(m-1,n,text1,dp);
        }else if(dp[m][n] == dp[m][n-1]) {
            return printLcs(m,n-1,text1,dp);
        }else {
            return text1.charAt(m-1) + printLcs(m-1,n-1,text1,dp);
        }
    }

    public static String findLCS(int l, int k, String text1, String text2){
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

        String s = printLcs(m,n,text1,dp);

        String reversedStr = "";

        for (int i = 0; i < s.length(); i++) {
            reversedStr = s.charAt(i) + reversedStr;
        }

        return reversedStr;
    }
}
