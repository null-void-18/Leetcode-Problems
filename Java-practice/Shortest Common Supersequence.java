
//DP Approach with LCS

public class Solution {
    private static String printLcs(int m,int n,String text1,String text2,int dp[][]) {
        if(m == 0 || n == 0) {
            return "";
        }
        
        if(dp[m][n] == dp[m-1][n]) {
            return printLcs(m-1,n,text1,text2,dp);
        }else if(dp[m][n] == dp[m][n-1]) {
            return printLcs(m,n-1,text1,text2,dp);
        }else {
            return text1.charAt(m-1) + printLcs(m-1,n-1,text1,text2,dp);
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

        String s = printLcs(m,n,text1,text2,dp);

        String reversedStr = "";

        for (int i = 0; i < s.length(); i++) {
            reversedStr = s.charAt(i) + reversedStr;
        }

        return reversedStr;
    }


    public static String shortestSupersequence(String a, String b) {
        int m = a.length();
        int n = b.length();
        String lcs = findLCS(a.length(),b.length(),a,b);
        String s1 = "";

        int i = 0;
        int j = 0;
        int z = 0;
        while(z < lcs.length()) {
            char x = lcs.charAt(z);
            while(i < m && j < n && a.charAt(i) != x && b.charAt(j) != x) {
                s1 += a.charAt(i);
                i += 1;
                s1 += b.charAt(j);
                j += 1;
            }
            

            while(i < m && a.charAt(i) != x) {
                s1 += a.charAt(i);
                i += 1;
            }

            while(j < n && b.charAt(j) != x) {
                s1 += b.charAt(j);
                j += 1;
            }
            
            
            if(i < m && a.charAt(i) == x) {
                i += 1;
            }

            if(j < n && b.charAt(j) == x) {
                j += 1;
            }

            s1 += x;
            z += 1;
        }

            while(i < m) {
                s1 += a.charAt(i);
                i += 1;
            }

            while(j < n) {
                s1 += b.charAt(j);
                j += 1;
            }
            
        return s1;
    }

}
