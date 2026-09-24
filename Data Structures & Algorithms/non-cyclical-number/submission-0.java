class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (sum != 1) {
            sum = 0;
            int digit = n % 10;
            sum = sum + digit * digit;
            while (n / 10 > 0) {
                n = n / 10;
                digit = n % 10;
                sum = sum + digit * digit;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            n = sum;
        }
        return true;
    }
}
