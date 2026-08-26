class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // hashset time & space O(n)
        // two pointer
        int leftIdx = 0;
        int rightIdx = numbers.length - 1;
        while (leftIdx < rightIdx) {
            int val = numbers[leftIdx] + numbers[rightIdx];
            if (val == target) {
                return new int[]{leftIdx + 1, rightIdx + 1};
            } else if (val < target) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
        return new int[]{-1, -1};
    }
}
