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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> pStack = searchNode(root, p);
        ArrayDeque<TreeNode> qStack = searchNode(root, q);
        while(pStack.size() > qStack.size()) {
            pStack.pop();
        }
        while (pStack.size() < qStack.size()) {
            qStack.pop();
        }
        while (!pStack.isEmpty()) {
            TreeNode ancestor = pStack.pop();
            if (ancestor == qStack.pop()) {
                return ancestor;
            }
        }
        return null;
    }

    private ArrayDeque<TreeNode> searchNode(TreeNode root, TreeNode goal) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root != null) {
            stack.push(root);
            if (root == goal) {
                break;
            }
            if (root.val > goal.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return stack;
    }
 }