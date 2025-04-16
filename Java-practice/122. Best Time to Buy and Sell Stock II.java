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
