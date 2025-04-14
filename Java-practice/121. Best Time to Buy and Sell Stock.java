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
