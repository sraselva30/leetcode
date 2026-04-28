class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff <= 0 || valueDiff < 0) return false;

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long current = (long) nums[i];

            // Find the smallest element >= (current - valueDiff)
            Long floor = set.ceiling(current - valueDiff);

            // Check if such element exists and is <= (current + valueDiff)
            if (floor != null && floor <= current + valueDiff) {
                return true;
            }

            set.add(current);

            // Maintain the sliding window of size indexDiff
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}
