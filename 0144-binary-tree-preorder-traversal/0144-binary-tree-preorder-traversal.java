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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> l = new ArrayList<>();
        if (root == null)
            return l;
        TreeNode ptr = root;
        while (ptr != null || !st.isEmpty()) {
            while (ptr != null) {
                l.add(ptr.val);
                st.push(ptr);
                ptr = ptr.left;
            }
            if (!st.isEmpty()) {
                ptr = st.pop().right;
            }
        }
        return l;
    }
}