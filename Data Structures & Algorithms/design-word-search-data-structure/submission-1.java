class WordDictionary {

    class TreeNode {
        TreeNode[] children = new TreeNode[26];
        boolean isEnd = false;
    }

    private TreeNode root;

    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
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
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TreeNode node) {
        TreeNode cur = node;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j] != null && searchInNode(word.substring(i + 1), cur.children[j])) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    return false;
                }
                 cur = cur.children[index];
            }
        }
        return cur.isEnd;
    }
}
