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
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        // if (root == null)
        //     return true;
        // int l = ht(root.left);
        // int r = ht(root.right);
        // if (Math.abs(r - l) > 1)
        //     return false;
        // return isBalanced(root.left) && isBalanced(root.right);
        helper(root);
        return flag;
    }

    private int helper(TreeNode root){
        if(root==null)
            return 0;
        
        int left=helper(root.left);
        int right=helper(root.right);
        if(Math.abs(left-right)>1)
            flag=false;
        return Math.max(left,right)+1;
        
    }

    private int ht(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(ht(root.left), ht(root.right)) + 1;
    }
}