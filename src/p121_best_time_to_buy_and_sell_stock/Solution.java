package p121_best_time_to_buy_and_sell_stock;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int maxProfit = 0, curMinPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int curProfit = prices[i] - curMinPrice;
            if (curProfit > 0 && curProfit > maxProfit) {
                maxProfit = curProfit;
            }

            if (prices[i] < curMinPrice)
                curMinPrice = prices[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }
}