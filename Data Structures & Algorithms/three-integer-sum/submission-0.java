class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // return all result
        // brute force: 3 for loop O(n^3)
        // Hashmap + 2 for loop O(n^2)
        // sort + two pointer + choose one O(nlogn + n^2)
        // -4 -1 -1 0 1 2
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    while(left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while(left < right - 1 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            while(i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}
