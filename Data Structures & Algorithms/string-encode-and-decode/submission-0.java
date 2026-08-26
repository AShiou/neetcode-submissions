class Solution {

    private static char separator = '#';


    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length());
            sb.append(separator);
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        char[] charArr = str.toCharArray();
        int i = 0;
        while (i < charArr.length) {
            int len = 0;
            while (i < charArr.length && charArr[i] != separator) {
                len = len * 10 + (charArr[i] - '0');
                i++;
            }
            i++;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                sb.append(charArr[i]);
                i++;
            }
            result.add(sb.toString());
        }
        return result;
    }
}
