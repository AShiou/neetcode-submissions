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

    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preL, int preR,
                        int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        int leftCount = rootIndex - inL;
        root.left = build(preorder, preL + 1, preL + leftCount,
                        inorder, inL, rootIndex - 1);
        root.right = build(preorder, preL + leftCount + 1, preR,
                        inorder, rootIndex + 1, inR);
        return root;
    }
}
