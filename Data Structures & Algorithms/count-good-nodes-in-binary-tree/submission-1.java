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

    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    private int countGoodNodes(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.val >= max) {
            count++;
        }
        max = Math.max(node.val, max);
        return count + countGoodNodes(node.left, max) + countGoodNodes(node.right, max);
    }
}
