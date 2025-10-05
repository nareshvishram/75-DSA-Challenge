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
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int inorder[], int start, int end) {
        if (start > end)
            return null;
        int currRoot = preorder[preIndex++];
        TreeNode root = new TreeNode(currRoot);
        int partitionIndex = map.get(currRoot);
        root.left = helper(preorder, inorder, start, partitionIndex - 1);
        root.right = helper(preorder, inorder, partitionIndex + 1, end);
        return root;
    }
}