class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // When nums[mid] == nums[right], we can't be sure where the min is.
                // Safely shrink the search space by moving the right pointer.
                right--;
            }
        }

        return nums[left];
    }
}
