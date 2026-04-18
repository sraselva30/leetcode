class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        // If there's only one element, you're already at the end
        if (n < 2) return 0;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            // Update the farthest index reachable from current position
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of our current jump's range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // Optimization: if we can already reach the last index, break
                if (currentEnd >= n - 1) break;
            }
        }
        return jumps;
    }
}
