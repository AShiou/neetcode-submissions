class Solution {
    public int[] twoSum(int[] nums, int target) {
        // brute force: n + (n-1) + ... 1 = (n+1)*n/2 -> O(n^2)
        // nums[0], for loop nums[1] ~ nums[n-1]
        // nums[1], for loop nums[2] ~ nums[n-1]
        // another method:
        // HashSet for loop to add -> O(n)
        Map<Integer, Integer> complementIndexMap = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++) {
            if(complementIndexMap.containsKey(nums[i])) {
                return new int[]{complementIndexMap.get(nums[i]), i};
            }
            complementIndexMap.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("no solution found");
    }
}
