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
    boolean ans=true;
    public boolean isValidBST(TreeNode root) {
        helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return ans;
    }
    private void helper(TreeNode root,long min,long max){
        if(root==null)
            return ;
        if(root.val>=max || root.val<=min)
            ans=false;
        helper(root.left,min,root.val);
        helper(root.right,root.val,max);
    }
}