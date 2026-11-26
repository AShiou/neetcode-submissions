class Solution {
    public int reverse(int x) {
        int result = 0;
        // max = 2,147,483,647
        int max = Integer.MAX_VALUE / 10;
        // min = -2,147,483,648
        int min = Integer.MIN_VALUE / 10;

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;

            if (result > max || result == max && digit > 7) {
                return 0;
            }
            if (result < min || result == min && digit < -8) {
                return 0;
            }
            result = result * 10 + digit;
        }
        return result;
    }
}
