package neetcode150.tree;

/**
 * Balanced Binary Tree
 * Solved
 * Given a binary tree, return true if it is height-balanced and false otherwise.
 * <p>
 * A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,null,null,4]
 * <p>
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,null,null,4,null,5]
 * <p>
 * Output: false
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return isBalanceds(root) != -1;
    }

    public int isBalanceds(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalanceds(root.left);
        if (left == -1) return -1;
        int right = isBalanceds(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}
