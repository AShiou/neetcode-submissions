class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int target, int start, 
                            int sum, List<Integer> path) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
        }
        for (int i = start; i < nums.length; i++) {
            if (sum + nums[i] <= target) {
                path.add(nums[i]);
                sum = sum + nums[i];
                if (sum + nums[i] <= target) {
                    backtrack(nums, target, i, sum, path);
                } else {
                    backtrack(nums, target, i + 1, sum, path);
                }
                path.remove(path.size() - 1);
                sum = sum - nums[i];
            }
        }
    }
}
