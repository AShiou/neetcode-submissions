class Solution {
    public boolean isPalindrome(String s) {
        // trim and just keep non-alpha
        // for loop check front and end
        String trimStr = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0;
        int right = trimStr.length() - 1;
        while (left < right) {
            if (trimStr.charAt(left) != trimStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
