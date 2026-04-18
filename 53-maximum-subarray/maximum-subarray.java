class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize with the first element
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decision: Start a new subarray at current element 
            // or extend the existing subarray?
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            
            // Update the global maximum found so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}
