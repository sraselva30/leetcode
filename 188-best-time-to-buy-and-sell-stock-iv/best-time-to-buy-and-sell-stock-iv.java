class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1 || k == 0) return 0;

        // If k is large enough, it becomes an "unlimited transactions" problem (Stock II)
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        // dp[i][0] = max profit with i transactions after buying
        // dp[i][1] = max profit with i transactions after selling
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - price); // Buy
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + price);     // Sell
            }
        }

        return dp[k][1];
    }
}
