class Solution {

    private static final char SEPARATOR = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append(SEPARATOR);
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int end = i;
            while (str.charAt(end) != SEPARATOR) {
                end++;
            }
            int count = Integer.parseInt(str.substring(i, end));
            result.add(str.substring(end + 1, end + count + 1));
            i = end + count + 1;
        }
        return result;
    }
}
