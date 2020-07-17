class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)return 0;
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i] < min)min = prices[i];
            int profit = prices[i + 1] - min;
            if(profit > maxProfit) maxProfit = profit;
        }
        return maxProfit;
    }
}