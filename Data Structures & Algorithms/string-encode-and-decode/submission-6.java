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
            int j = i;
            while (str.charAt(j) != SEPARATOR) {
                j++;
            }
            int count = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            int end = start + count;
            result.add(str.substring(start, end));
            i = end;
        }
        return result;
    }
}
