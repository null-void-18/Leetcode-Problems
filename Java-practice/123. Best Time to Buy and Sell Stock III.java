class Solution {
    public int maxProfit(int[] prices)  {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }
}


//DP Approach with Memory optimized

class Solution {

    public int maxProfit(int[] prices)  {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        int curr[][] = new int[2][3],after[][] = new int[2][3];
        

        for(int row[] : curr) {
            Arrays.fill(row,0);
        } 
        for(int row[] : after) {
            Arrays.fill(row,0);
        }

        for(int index = n-1;index >= 0;index--) {
            for(int buy = 0; buy <= 1;buy++) {
                for(int count = 1;count <= 2;count++) {
                    if(buy == 1) {
                        curr[buy][count] = Math.max(-prices[index] + after[0][count],after[1][count]);
                    }
                    else {
                        curr[buy][count] = Math.max(prices[index] + after[1][count-1],after[0][count]);
                    }
                }
            }
            for (int i = 0; i < curr.length; i++) {
                System.arraycopy(curr[i], 0, after[i], 0, curr[i].length);
            }
        }

        return after[1][2];
    }
}




//DP Approach

class Solution {

    public int maxProfit(int[] prices)  {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][4];


        for(int index = n-1;index >= 0;index--) {
            for(int buy = 0; buy <= 1;buy++) {
                for(int count = 1;count <= 3;count++) {
                    if(buy == 1) {
                        dp[index][buy][count] = Math.max(-prices[index] + dp[index+1][0][count],dp[index+1][1][count]);
                    }
                    else {
                        dp[index][buy][count] = Math.max(prices[index] + dp[index+1][1][count-1],dp[index+1][0][count]);
                    }
                }
            }
        }

        return dp[0][1][2];
    }
}
