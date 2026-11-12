class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int h : hand) {
            if (countMap.containsKey(h)) {
                countMap.put(h, countMap.get(h) + 1);
            } else {
                countMap.put(h, 1);
            }
        }
        Arrays.sort(hand);
        for (int h : hand) {
            if (countMap.get(h) == 0) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int current = h + i;
                if (!countMap.containsKey(current)) {
                    return false;
                }
                int frequency = countMap.get(current);
                if (frequency == 0) {
                    return false;
                }
                countMap.put(current, frequency - 1);
            }
        }
        return true;
    }
}
