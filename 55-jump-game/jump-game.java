class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // If the current index is beyond the farthest reachable point, we're stuck
            if (i > farthest) {
                return false;
            }
            
            // Update the farthest index we can reach from here
            farthest = Math.max(farthest, i + nums[i]);
            
            // Optimization: If we can already reach the end, return true
            if (farthest >= n - 1) {
                return true;
            }
        }

        return false;
    }
}
