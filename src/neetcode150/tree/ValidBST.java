package neetcode150.tree;

/**
 * Valid Binary Search Tree
 * Solved
 * Given the root of a binary tree, return true if it is a valid binary search tree, otherwise return false.
 * <p>
 * A valid binary search tree satisfies the following constraints:
 * <p>
 * The left subtree of every node contains only nodes with keys less than the node's key.
 * The right subtree of every node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees are also binary search trees.
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [2,1,3]
 * <p>
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3]
 * <p>
 * Output: false
 * Explanation: The root node's value is 1 but its left child's value is 2 which is greater than 1.
 * <p>
 * Constraints:
 * <p>
 * 1 <= The number of nodes in the tree <= 1000.
 * -1000 <= Node.val <= 1000
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int low, int high) {
        if (root == null) {
            return true;
        }
        if (root.val <= low || root.val >= high) {
            return false;
        }
        return isValidBST(root.left, low, root.val)
                && isValidBST(root.right, root.val, high);

    }
}
