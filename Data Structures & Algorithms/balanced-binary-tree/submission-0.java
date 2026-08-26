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
    boolean heightBalanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return heightBalanced;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        int diff = Math.abs(left - right);
        if (diff > 1 && heightBalanced) {
            heightBalanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
