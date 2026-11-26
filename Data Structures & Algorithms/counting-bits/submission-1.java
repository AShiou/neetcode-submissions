class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = countBit(i);
        }
        return result;
    }

    private int countBit(int n) {
        int count = 0;
        while (n != 0) {
            count = count + (n & 1);
            n = n >> 1;
        }
        return count;
    }
}
