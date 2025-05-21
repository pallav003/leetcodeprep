package neetcode150.tree;

/**
 * Count Good Nodes in Binary Tree
 * Solved
 * Within a binary tree, a node x is considered good if the path from
 * the root of the tree to the node x contains no nodes with a value greater
 * than the value of node x
 * <p>
 * Given the root of a binary tree root, return the number of good nodes within the tree.
 * <p>
 * Example 1:
 * Input: root = [2,1,1,3,null,1,5]
 * <p>
 * Output: 3
 * Example 2:
 * <p>
 * Input: root = [1,2,-1,3,4]
 * <p>
 * Output: 4
 *
 */
public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode root, int max) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        count += root.val >= max ? 1 : 0;
        max = Math.max(max, root.val);
        count += goodNodes(root.left, max);
        count += goodNodes(root.right, max);
        return count;
    }
}
