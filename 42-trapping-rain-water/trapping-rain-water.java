class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            // Process the shorter side
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update left wall
                } else {
                    totalWater += leftMax - height[left]; // Trap water
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update right wall
                } else {
                    totalWater += rightMax - height[right]; // Trap water
                }
                right--;
            }
        }

        return totalWater;
    }
}