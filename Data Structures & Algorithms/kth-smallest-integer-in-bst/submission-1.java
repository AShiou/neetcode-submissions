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

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return maxHeap.peek();
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (maxHeap.size() == k) {
            if (maxHeap.peek() > root.val) {
                maxHeap.poll();
                maxHeap.add(root.val);
            }
        } else {
            maxHeap.add(root.val);
        }
        dfs(root.left, k);
        dfs(root.right, k);
    }
}
