

//Recursion with Memoization

class Solution {


    int profit(int dp[][][],int prices[],int index,int buy,int cooldown) {
        if(index == prices.length) {
            return 0;
        }

        if(dp[index][buy][cooldown] != -1) return dp[index][buy][cooldown];

        if(buy == 1 && cooldown != 1) {
            return dp[index][buy][cooldown] = Math.max(-prices[index] + profit(dp,prices,index+1,0,0),profit(dp,prices,index+1,1,0));
        }
        else if(cooldown != 1){
            return dp[index][buy][cooldown] = Math.max(prices[index] + profit(dp,prices,index+1,1,1),profit(dp,prices,index+1,0,0));
        }else {
            return dp[index][buy][cooldown] = profit(dp,prices,index+1,1,0);
        }
    }


    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][2];

        for(int rows[][] : dp) {
            for(int row[] : rows) {
                Arrays.fill(row,-1);
            }
        }

        return profit(dp,prices,0,1,0);
    }
}
