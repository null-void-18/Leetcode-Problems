


//DP Approach


class Solution {

    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length+1][2][2];

        for(int rows[][] : dp) {
            for(int row[] : rows) {
                Arrays.fill(row,0);
            }
        }
        int n = prices.length;

        for(int index = n-1;index >= 0;index--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cooldown = 1; cooldown >= 0;cooldown--) {
                    if(buy == 1 && cooldown != 1) {
                        dp[index][buy][cooldown] = Math.max(-prices[index] + dp[index+1][0][0],dp[index+1][1][0]);
                    }
                    else if(cooldown != 1){
                        dp[index][buy][cooldown] = Math.max(prices[index] + dp[index+1][1][1],dp[index+1][0][0]);
                    }else {
                        dp[index][buy][cooldown] = dp[index+1][1][0];
                    }
                }
            }
        }

        return dp[0][1][0];
    }
}


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
