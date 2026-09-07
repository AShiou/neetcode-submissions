class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int minLen = Math.min(word1.length(), word2.length());
            
            int j = 0;

            while (j < minLen && word1.charAt(j) == word2.charAt(j)) {
                j++;
            }

            if (j == minLen) {
                if (word1.length() > word2.length()) {
                    return "";
                }
                continue;
            }

            char from = word1.charAt(j);
            char to = word2.charAt(j);
            if (!graph.get(from).contains(to)) {
                graph.get(from).add(to);
                indegree.put(to, indegree.get(to) + 1);
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);
            for (char next : graph.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if(indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        if (result.length() != indegree.size()) {
            return "";
        }
        return result.toString();
    }
}
