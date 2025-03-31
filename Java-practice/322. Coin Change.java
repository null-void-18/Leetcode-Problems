
//DP Approach



class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}



//Recursion

class Solution {
    int calculate(int n, int amount, int coins[]) {
        if(amount == 0) {
            return 0;
        }
        
        if(n < 0 || amount < 0) {
            return Integer.MAX_VALUE;
        }

        int notTake = calculate(n-1, amount, coins);
        
        int take = Integer.MAX_VALUE;
        if(coins[n] <= amount) {
            int temp = calculate(n, amount - coins[n], coins);
            if(temp != Integer.MAX_VALUE) {
            take = 1 + temp;
            }
        }

        return Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int ans = calculate(n-1, amount, coins);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
