//买卖股票的最佳时机II
class Solution {
    public int maxProfit(int[] prices) {
        // 做了第一道题后，再做这题就不是很难，直接On方法拿下
        int buy = Integer.MAX_VALUE, profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = Integer.MAX_VALUE;
            }
            // 可以当天卖了当天买，不能用else if
            if (prices[i] < buy)
                buy = prices[i];
        }
        return profit;
    }
}