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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, 
                        int preStart, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int mid = inLeft;
        while (root.val != inorder[mid]) {
            mid++;
        }
        int leftSize = mid - inLeft;
        root.left = build(preorder, inorder, preStart + 1, inLeft, mid - 1);
        root.right = build(preorder, inorder, preStart + leftSize + 1, mid + 1, inRight);
        return root;
    }
}
