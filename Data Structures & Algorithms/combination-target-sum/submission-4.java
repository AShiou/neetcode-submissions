class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int remaining, int start, List<Integer> path) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remaining) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, remaining - nums[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}
