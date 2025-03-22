package neetcode150.tree;

/**
 * Same Binary Tree
 * Solved
 * Given the roots of two binary trees p and q, return true if the trees are equivalent, otherwise return false.
 * <p>
 * Two binary trees are considered equivalent if they share the exact same structure and the nodes have the same values.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: p = [1,2,3], q = [1,2,3]
 * <p>
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: p = [4,7], q = [4,null,7]
 * <p>
 * Output: false
 */
public class SameBinaryTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
