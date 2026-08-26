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
        while (!set.isEmpty()) {
            int val = set.iterator().next();
            set.remove(val);
            int count = 1;
            int incre = val + 1;
            while(set.contains(incre)) {
                set.remove(incre);
                count++;
                incre = incre + 1;
            }
            int decre = val - 1;
            while(set.contains(decre)) {
                set.remove(decre);
                count++;
                decre = decre - 1;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
