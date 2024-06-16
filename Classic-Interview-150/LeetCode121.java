//买卖股票的最佳时机
class Solution {
    public int maxProfit(int[] prices) {
        // 直接暴力求解，会超时
        // int max = 0, maxI = -1, maxJ = -1;
        // for (int i = 0; i < prices.length; i++) {
        //     for (int j = i + 1; j < prices.length; j++) {
        //         if (prices[j] - prices[i] > max) {
        //             max = prices[j] - prices[i];
        //             maxI = i;
        //             maxJ = j;
        //         }
        //     }
        // }
        // return max;

        // 维护一个最小值，On复杂度
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else if (prices[i] - min > max)
                max = prices[i] - min;

        }
        return max;
    }
}