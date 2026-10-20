class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBananas = 0;
        for (int pile : piles) {
            maxBananas = Math.max(pile, maxBananas);
        }
        int left = 1;
        int right = maxBananas;
        int result = right;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long totalTime = 0;
            for (int pile : piles) {
                totalTime = totalTime + (pile + mid - 1) / mid;
            }
            if (totalTime > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }
        return result;
    }
}
