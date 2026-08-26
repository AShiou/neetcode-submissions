class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // if k > distinct numbers, throw exception
        // HashMap: key:integer, value: count
        // sort count
        // return key
        // O(n + nlogn)
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        for (int num: nums) {
            elementCountMap.put(num, elementCountMap.getOrDefault(num, 0) + 1);
        }
        if (elementCountMap.size() < k) {
            throw new IllegalArgumentException("no solution found");
        }

        // convert to list and then sort
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(elementCountMap.entrySet());
        sortedEntries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));


        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedEntries.get(i).getKey();
        }
        return result;
    }
}
