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

    private boolean result = false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        dfs(root, subRoot);
        return result;
    }

    public void dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return;
        }
        if (root.val == subRoot.val && isSameTree(root, subRoot)) {
            result = true;
            return;
        }
        dfs(root.left, subRoot);
        dfs(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return root.val == subRoot.val
            && isSameTree(root.left, subRoot.left) 
            && isSameTree(root.right, subRoot.right);
    }
}
