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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Data> q = new LinkedList<>();
        q.add(new Data(0, root));
        int ans = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            int tmp1 = 0, tmp2 = 0;
            boolean foundFirst = false;
            while (size-- > 0) {
                Data curr = q.poll();
                if (curr.node.left != null) {
                    q.add(new Data(2 * curr.idx + 1, curr.node.left));
                    if (!foundFirst) {
                        tmp1 = 2 * curr.idx + 1;
                        foundFirst = true;
                    }
                    tmp2 = 2 * curr.idx + 1;
                }
                if (curr.node.right != null) {
                    q.add(new Data(2 * curr.idx + 2, curr.node.right));
                    if (!foundFirst) {
                        tmp1 = 2 * curr.idx + 2;
                        foundFirst = true;
                    }
                    tmp2 = 2 * curr.idx + 2;
                }
            }
            ans = Math.max(Math.abs(tmp2 - tmp1) + 1, ans);
        }
        return ans;
    }
}

class Data {
    int idx;
    TreeNode node;

    Data(int idx, TreeNode node) {
        this.idx = idx;
        this.node = node;
    }
}