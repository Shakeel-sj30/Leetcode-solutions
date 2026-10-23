
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        height(root);
        return maxSum;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, height(node.left));
        int right = Math.max(0, height(node.right));

        maxSum = Math.max(maxSum, left + right + node.val);

        return node.val + Math.max(left, right);
    }
}
