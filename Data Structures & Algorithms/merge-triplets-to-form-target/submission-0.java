class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // brute force O(n^3)
        // for(to find 5)
        //    for (to find 4)
        //        for (to find 6)
        // hashmap: use 3 hashmap, O(n)
        boolean[] result = new boolean[3];
        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }
            if (t[0] == target[0]) {
                result[0] = true;
            }
            if (t[1] == target[1]) {
                result[1] = true;
            }
            if (t[2] == target[2]) {
                result[2] = true;
            }
        }
        return result[0] && result[1] && result[2];
    }
}
