class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(
        int[] nums, 
        int target, 
        int start, 
        List<Integer> path, 
        List<List<Integer>> result) {
            
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            path.add(nums[i]);
            backtrack(nums, target - nums[i], i, path, result);
            path.remove(path.size() - 1);
        }
    }
}
