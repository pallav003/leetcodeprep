package neetcode150.tree;

/**
 * Subtree of Another Tree
 * Solved
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * <p>
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5], subRoot = [2,4,5]
 * <p>
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,null,null,6], subRoot = [2,4,5]
 * <p>
 * Output: false
 * Constraints:
 * <p>
 * 0 <= The number of nodes in both trees <= 100.
 * -100 <= root.val, subRoot.val <= 100
 */
public class SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }
}
