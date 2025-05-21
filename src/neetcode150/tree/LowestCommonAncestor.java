package neetcode150.tree;

/**
 * Lowest Common Ancestor in Binary Search Tree
 * Given a binary search tree (BST) where all node values are unique, and
 * two nodes from the tree p and q, return the lowest common ancestor (LCA) of the two nodes.
 * <p>
 * The lowest common ancestor between two nodes p and q is the lowest node in
 * a tree T such that both p and q as descendants. The ancestor is allowed to be a
 * descendant of itself.
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [5,3,8,1,4,7,9,null,2], p = 3, q = 8
 * <p>
 * Output: 5
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [5,3,8,1,4,7,9,null,2], p = 3, q = 4
 * <p>
 * Output: 3
 * Explanation: The LCA of nodes 3 and 4 is 3, since a node can be a descendant of itself.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    public TreeNode recursiveSolution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p.val > root.val && q.val > root.val) {
            return recursiveSolution(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return recursiveSolution(root.left, p, q);
        } else {
            return root;
        }
    }

    private TreeNode getTreeNode(TreeNode root, TreeNode p, TreeNode q) {
        return recursiveSolution(root.right, p, q);
    }
}
