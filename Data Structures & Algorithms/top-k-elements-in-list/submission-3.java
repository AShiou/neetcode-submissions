class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Hashmap
        // 可以把每個數字放進 Hashmap 並且 count，再將 count 做 sort
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}
