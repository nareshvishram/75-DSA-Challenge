/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        ht(root);
        return ans;
    }

    private int ht(TreeNode root) {
        if (root == null)
            return 0;
        int lh = ht(root.left);
        int rh = ht(root.right);
        if (Math.abs(lh - rh) > 1) 
            ans = false;
        
        return Math.max(lh, rh) + 1;
    }
}