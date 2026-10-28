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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String element = queue.poll();
        if (element.equals("#")) {
            return null;
        }
        int val = Integer.valueOf(element);
        TreeNode node = new TreeNode(val);
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }
}
