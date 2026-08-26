class Solution {
    public int longestConsecutive(int[] nums) {
        // sort O(nlogn)
        // 2, 3, 4, 4, 5, 10
        // hashset 2, 3, 4, 5, 10
        // 2 find 3 or 1, 3 -> 4 -> 5
        // 0, 3, 2, 5, 4, 6, 1, 1
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int num: set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int incre = num + 1;
                while (set.contains(incre)) {
                    count++;
                    incre++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
