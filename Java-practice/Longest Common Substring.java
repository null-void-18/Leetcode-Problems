//DP Approach

class Solution {

    public static int lcs(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int dp[][] = new int[m + 1][n + 1]; 
        int ans = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; 
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; 
                    ans = Math.max(ans,dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}


//Recursion

public class Solution {

    static int calculate(int m, int n, String s, String t, int count) {
        // Base case: if either string runs out of characters
        if (m < 0 || n < 0) return count;

        // If characters match, increase the count of common substring length
        if (s.charAt(m) == t.charAt(n)) {
            count = calculate(m - 1, n - 1, s, t, count + 1);
        } else {
            // Reset count if characters don't match, as it's a substring
            return count;
        }

        // Return the maximum value found
        return Math.max(count, Math.max(calculate(m - 1, n, s, t, 0), calculate(m, n - 1, s, t, 0)));
    }

    public static int lcs(String s, String t) {
        int m = s.length();
        int n = t.length();
        int maxLength = 0;

        // Try to find the longest common substring from every position in both strings
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                maxLength = Math.max(maxLength, calculate(i, j, s, t, 0));
            }
        }

        return maxLength;
    }
}

