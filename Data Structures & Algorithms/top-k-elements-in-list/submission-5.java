class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i > 0 && index < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (int num : buckets[i]) {
                res[index] = num;
                index++;

                if (index == k) {
                    break;
                }
            }
        }
        return res;
    }
}
