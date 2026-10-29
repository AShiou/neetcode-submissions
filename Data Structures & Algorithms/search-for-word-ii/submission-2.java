class Solution {

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

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
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
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search(board, i, j, root, "", result);
            }
        }
        return result;
    }

    private void search(char[][] board, int r, int c, 
                        TrieNode node, String path, List<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }
        char ch = board[r][c];
        if (ch == '#') {
            return;
        }
        int index = ch - 'a';
        if (node.children[index] == null) {
            return;
        }
        TrieNode next = node.children[index];
        path = path + ch;
        
        if (next.isEnd) {
            result.add(path);
            next.isEnd = false;
        }
        board[r][c] = '#';
        search(board, r+1, c, next, path, result);
        search(board, r-1, c, next, path, result);
        search(board, r, c+1, next, path, result);
        search(board, r, c-1, next, path, result);
        board[r][c] = ch;
    }
}
