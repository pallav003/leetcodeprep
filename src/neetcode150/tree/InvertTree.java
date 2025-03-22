package neetcode150.tree;

/**
 * Invert Binary Tree
 * Solved
 * You are given the root of a binary tree root. Invert the binary tree and return its root.
 * <p>
 * Input: root = [1,2,3,4,5,6,7]
 * <p>
 * Output: [1,3,2,7,6,5,4]
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode treeNode = new TreeNode(root.val);
        treeNode.left = invertTree(root.right);
        treeNode.right = invertTree(root.left);
        return treeNode;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

