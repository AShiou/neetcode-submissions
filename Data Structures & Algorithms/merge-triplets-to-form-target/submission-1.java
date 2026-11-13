class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] current = new int[3];
        current[0] = 0;
        current[1] = 0;
        current[2] = 0;
        for (int[] triplet : triplets) {
            int first = Math.max(current[0], triplet[0]);
            if (first > target[0]) {
                continue;
            }
            int second = Math.max(current[1], triplet[1]);
            if (second > target[1]) {
                continue;
            }
            int third = Math.max(current[2], triplet[2]);
            if (third > target[2]) {
                continue;
            }
            current[0] = first;
            current[1] = second;
            current[2] = third;
        }
        if (current[0] != target[0] 
            || current[1] != target[1] 
            || current[2] != target[2]) {
            return false;
        }
        return true;
    }
}
