class PrefixTree {
    class TreeNode {
        TreeNode[] children = new TreeNode[26];
        boolean isEnd = false;
    }

    private TreeNode root;

    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TreeNode();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode cur = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for (char c: prefix.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }
}
