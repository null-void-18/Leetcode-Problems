
//Best Solution

class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            while (i < N && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];

            while (i < N && prices[i + 1] > prices[i]) i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }
}






//My solution

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0],max = prices[0];
        boolean flag = false;
        for(int i = 1;i < prices.length;i++) {
            if(max < prices[i]) {
                max = prices[i];
            }else {
                if(i == prices.length - 1) flag = true;
                profit += (max - min);
                min = prices[i];
                max = prices[i];
            }
        }

        if(!flag) {
            profit += (max - min);
        }

        return profit;
    }
}


//Recursion with Memoization 

class Solution {
    int profit(int dp[][],int prices[],int index,int buy) {
        if(index == prices.length) {
            return 0;
        }

        if(dp[index][buy] != -1) {
            return dp[index][buy];
        }

        if(buy == 1) {
            return dp[index][buy] = Math.max(-prices[index] + profit(dp,prices,index+1,0),profit(dp,prices,index+1,1));
        }
        else {
            return dp[index][buy] = Math.max(prices[index] + profit(dp,prices,index+1,1),profit(dp,prices,index+1,0));
        }
    }

    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int row[] : dp) {
            Arrays.fill(row,-1);
        }
        return profit(dp,prices,0,1);
    }
}
