class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        gainFromSubtree(root);
        return maxSum;
    }

    private int gainFromSubtree(TreeNode root) {
        if (root == null) return 0;

        // Recursively get the max gain from left and right subtrees
        // Ignore paths with negative sums by using Math.max(0, ...)
        int leftGain = Math.max(gainFromSubtree(root.left), 0);
        int rightGain = Math.max(gainFromSubtree(root.right), 0);

        // Price of the new path including the current node as the highest point (arc)
        int currentPathSum = root.val + leftGain + rightGain;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPathSum);

        // For recursion, return the max gain the parent can get from this node
        return root.val + Math.max(leftGain, rightGain);
    }
}