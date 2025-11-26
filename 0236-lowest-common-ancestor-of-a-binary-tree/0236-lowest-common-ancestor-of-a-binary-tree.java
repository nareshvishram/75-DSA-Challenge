/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return lca;
    }

    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        boolean mid = (root == p) || (root == q);
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        int eval = (left ? 1 : 0) + (right ? 1 : 0) + (mid ? 1 : 0);
        if (eval >= 2)
            lca = root;
        return left || right || mid;
    }
}