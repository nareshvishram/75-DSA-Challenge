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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> l = new ArrayList<>();

        if (root == null)
            return l;
        TreeNode ptr = root;
        while (!st.isEmpty() || ptr != null) {
            while (ptr != null) {
                st.push(ptr);
                st.push(ptr);
                ptr = ptr.left;
            }
            if (!st.isEmpty()) {
                TreeNode tmp = st.pop();
                if (!st.isEmpty()) {
                    if (tmp == st.peek())
                        ptr = tmp.right;
                    else
                        l.add(tmp.val);
                } else
                    l.add(tmp.val);
            }
        }
        return l;
    }
}