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
    int ans=-1;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        // if(root==null)
        //     return -1;
        // kthSmallest(root.left,k-1);
        // if(k==0)
        //     return root.val;
        // kthSmallest(root.right,k-1);
        this.k=k;
        helper(root);
        return ans;
        
        
    }
    private void helper(TreeNode root){
        if(root==null||k<0)
            return ;
        helper(root.left);
        k--;
        if(k==0)
            ans=root.val;
        helper(root.right);
    }
}