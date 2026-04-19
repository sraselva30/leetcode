class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        // Initial condition: 1 way to be at the start if it's not an obstacle
        dp[0] = (obstacleGrid[0][0] == 0) ? 1 : 0;

        for (int[] row : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) {
                    dp[j] = 0; // Obstacle: no paths possible
                } else if (j > 0) {
                    // Current cell = Paths from Top (dp[j]) + Paths from Left (dp[j-1])
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}
