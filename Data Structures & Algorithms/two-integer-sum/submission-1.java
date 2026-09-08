class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] sortedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i][0] = nums[i];
            sortedNums[i][1] = i;
        }
        Arrays.sort(sortedNums, Comparator.comparingInt(a -> a[0]));
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int cur = sortedNums[left][0] + sortedNums[right][0];
            if (cur == target) {
                return new int[]{Math.min(sortedNums[left][1], sortedNums[right][1]),
                                 Math.max(sortedNums[left][1], sortedNums[right][1])};
            }
            if (cur < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
}
