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
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return inorder(root);
    }

    private int inorder(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int left = inorder(node.left);
        if (left != -1) {
            return left;
        }
        k--;
        if (k == 0) {
            return node.val;
        }
        return inorder(node.right);
    }
}
