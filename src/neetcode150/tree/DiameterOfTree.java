package neetcode150.tree;

/**
 * Diameter of Binary Tree
 * Solved
 * The diameter of a binary tree is defined as the length of the longest path
 * between any two nodes within the tree. The path does not necessarily have to
 * pass through the root.
 * <p>
 * The length of a path between two nodes in a binary tree is the number of edges between the nodes.
 * <p>
 * Given the root of a binary tree root, return the diameter of the tree.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,null,2,3,4,5]
 * <p>
 * Output: 3
 * Explanation: 3 is the length of the path [1,2,3,5] or [5,3,2,4].
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,2,3]
 * <p>
 * Output: 2a
 */
public class DiameterOfTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1]; // Use an array to track max diameter
        getDiameter(root, maxDiameter);
        return maxDiameter[0];
    }

    public int getDiameter(TreeNode root, int[] output) {
        if (root == null) {
            return 0;
        }
        int left = getDiameter(root.left, output);
        int right = getDiameter(root.right, output);
        output[0] = Math.max(output[0], left + right);
        return 1 + Math.max(left, right);
    }
}
