
//





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


    public int longestPalindromeSubseq(String text1) {
        int m = text1.length();

        String text2 = "";
        for (int i = 0; i < text1.length(); i++) {
        text2 = text1.charAt(i) + text2;
        }

        int n = text2.length();

        int dp[][] = new int[m][n];

        for(int row[] : dp) {
            Arrays.fill(row,-1);
        }

        return calculate(m-1,n-1,text1,text2,dp);
    }
}
