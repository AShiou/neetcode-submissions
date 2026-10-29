class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;

        TrieNode() {
            isEnd = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return searchSubstring(word, root);
    }

    private boolean searchSubstring(String word, TrieNode node) {
        TrieNode cur = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j] != null
                        && searchSubstring(word.substring(i + 1), cur.children[j])) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    return false;
                }
                cur = cur.children[index];
            } 
        }
        return cur.isEnd;
    }
}
