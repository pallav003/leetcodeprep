package neetcode150.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Right Side View
 * Solved
 * You are given the root of a binary tree. Return only the values of the
 * nodes that are visible from the right side of the tree, ordered from top to bottom.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3]
 * <p>
 * Output: [1,3]
 * Example 2:
 * <p>
 * Input: root = [1,2,3,4,5,6,7]
 * <p>
 * Output: [1,3,7]
 * Constraints:
 * <p>
 * 0 <= number of nodes in the tree <= 100
 * -100 <= Node.val <= 100
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        rightSideView(root, 0, output);
        return output;

    }

    public void rightSideView(TreeNode root, int level,
                              List<Integer> output) {
        if (root == null) {
            return;
        }
        if (output.size() == level) {
            output.add(root.val);
        }
        rightSideView(root.right, level + 1, output);
        rightSideView(root.left, level + 1, output);
    }
}
