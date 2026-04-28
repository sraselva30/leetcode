class Solution {
    private Map<Integer, Integer> inorderMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();
        
        // Build a map to find the index of any value in inorder array in O(1)
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // If there are no elements to construct the tree
        if (left > right) return null;

        // Select the preorderIndex element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Build left and right subtrees based on the root's index in inorder array
        int mid = inorderMap.get(rootValue);
        root.left = arrayToTree(preorder, left, mid - 1);
        root.right = arrayToTree(preorder, mid + 1, right);

        return root;
    }
}