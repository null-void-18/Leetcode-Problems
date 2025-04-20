class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int value = prices[0];
        for(int i = 1;i < prices.length;i++) {
            ans = Math.max(ans,prices[i] - value);
            value = Math.min(value,prices[i]);
        }
        return ans;
    }
}




//Recursion with Memoization
class Solution { 

    int profit(int dp[][],int prices[],int index,int buy) {
        if(index == prices.length || buy == 2) {
            return 0;
        }

        if(dp[index][buy] != -1) return dp[index][buy];

        if(buy == 1) {
            return dp[index][buy] = Math.max(-prices[index] + profit(dp,prices,index+1,0),profit(dp,prices,index+1,1));
        }
        else {
            return dp[index][buy] = Math.max(prices[index] + profit(dp,prices,index+1,2),profit(dp,prices,index+1,0));
        }
    }


    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][3];

        for(int row[] : dp) {
            Arrays.fill(row,-1);
        }

        return profit(dp,prices,0,1);
    }
}
