class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile: piles) {
            right = Math.max(pile, right);
        }
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int pile: piles) {
                hours = hours + (int)Math.ceil((double)pile / mid);
            }
            if (hours > h) {
                left = mid + 1;
            } else {
                result = Math.min(result, mid);
                right = mid - 1;
            }
        }
        return result;
    }
}
