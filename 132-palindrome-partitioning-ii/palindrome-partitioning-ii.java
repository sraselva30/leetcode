class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        // dp[i] stores the minimum cuts for substring s[0...i-1]
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = i - 1;

        for (int i = 0; i < n; i++) {
            // Odd length palindromes (centered at i)
            expand(s, i, i, dp);
            // Even length palindromes (centered at i and i+1)
            expand(s, i, i + 1, dp);
        }

        return dp[n];
    }

    private void expand(String s, int left, int right, int[] dp) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // Substring s[left...right] is a palindrome
            // dp[right+1] is min of current or cuts for s[0...left-1] + 1 new cut
            dp[right + 1] = Math.min(dp[right + 1], dp[left] + 1);
            left--;
            right++;
        }
    }
}
