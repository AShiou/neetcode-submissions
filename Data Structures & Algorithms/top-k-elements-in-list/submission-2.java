class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        for (int num: nums) {
            elementCountMap.put(num, elementCountMap.getOrDefault(num, 0) + 1);
        }
        if (elementCountMap.size() < k) {
            throw new IllegalArgumentException("no solution found");
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry: elementCountMap.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(entry.getKey());
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                resultList.addAll(buckets[i]);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
