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

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getLength(root);
        return max;
    }

    private int getLength(TreeNode root) {
        int left = (root.left == null) ? 0 : getLength(root.left) + 1;
        int right = (root.right == null) ? 0 : getLength(root.right) + 1;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
