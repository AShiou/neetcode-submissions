class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n;
        for (int i = 0; i < n; i++) {
            sum ^= i;
            sum ^= nums[i];
        }
        return sum;
    }
}
