class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        // dp[i][j] represents the minimum health needed before entering room (i, j)
        int[][] dp = new int[m + 1][n + 1];

        // Initialize boundary with infinity
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        // Base case: the health needed after the princess room is 1
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;

        // Bottom-up DP from the bottom-right to the top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int minHealthNeeded = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                // Health must be at least 1 at any point
                dp[i][j] = Math.max(1, minHealthNeeded);
            }
        }

        return dp[0][0];
    }
}
