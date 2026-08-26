class Solution {
    public boolean hasDuplicate(int[] nums) {
        // use hashset, for loop to check
        Set seenNumbers = new HashSet<>();
        for (int num: nums) {
            if (seenNumbers.contains(num)) {
                return true;
            }
            seenNumbers.add(num);
        }
        return false;
    }
}