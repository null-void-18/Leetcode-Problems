
//DP Approach

class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];

        for(int i = 0; i < n;i++) {
            dp[i][0] = 1;
        }

        for(int i = 0; i < n;i++) {
            for(int j = 1; j <= amount;j++) {
                int ans = 0;
                if(j - coins[i] >= 0) {
                    ans += dp[i][j - coins[i]];
                }
                if(i - 1 >= 0) {
                    ans += dp[i - 1][j];
                }
                dp[i][j] = ans;
            }
        }

        return dp[n-1][amount];
    }
}





// Recursion with Memoization

class Solution {

    int calculate(int start, int len, int amount, int coins[], int dp[][]) {
        if (amount == 0) {
            return 1;
        }

        if (start >= len || amount < 0) {
            return 0;
        }

        if(dp[start][amount] != -1) return dp[start][amount];

        int ans = 0;

        ans += calculate(start, len, amount - coins[start], coins, dp);

        ans += calculate(start + 1, len, amount, coins, dp);

        return dp[start][amount] = ans;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];

        for(int row[] : dp) {
            Arrays.fill(row,-1);
        }


        return calculate(0, coins.length, amount, coins, dp);
    }
}
