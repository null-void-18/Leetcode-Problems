


//Recursion with Memoization

class Solution {

    int profit(int dp[][],int prices[],int index,int buy,int fee) {
        if(index == prices.length) {
            return 0;
        }

        if(dp[index][buy] != -1) return dp[index][buy];

        if(buy == 1) {
            return dp[index][buy] = Math.max(-prices[index] + profit(dp,prices,index+1,0,fee),profit(dp,prices,index+1,1,fee));
        }
        else {
            return dp[index][buy] = Math.max(-fee + prices[index] + profit(dp,prices,index+1,1,fee),profit(dp,prices,index+1,0,fee));
        }
    }



    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for(int row[] : dp) {
            Arrays.fill(row,-1);
        }
        return profit(dp,prices,0,1,fee);
    }
}
