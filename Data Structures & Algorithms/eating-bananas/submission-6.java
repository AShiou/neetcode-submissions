class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long bananas = 0;
        int maxBananas = 0;
        for (int pile : piles) {
            bananas = bananas + pile;
            maxBananas = Math.max(pile, maxBananas);
        }
        int left = (int)((bananas + h - 1) / h);
        int right = maxBananas;
        int result = right;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long hours = 0;
            for (int pile : piles) {
                hours = hours + (pile + mid - 1) / mid;
            }
            if (hours > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = Math.min(result, mid);
            }
        }
        return result;
    }
}
