class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[j] will store the number of distinct subsequences of t[0...j-1] in s[0...i-1]
        int[] dp = new int[n + 1];
        
        // Base case: empty t is a subsequence of any s (exactly 1 way)
        dp[0] = 1;
        
        for (int i = 1; i <= m; i++) {
            // Iterate backwards to use values from the "previous row" without extra space
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        
        return dp[n];
    }
}
