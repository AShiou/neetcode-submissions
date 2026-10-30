class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new HashSet<>(), new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, Set<Integer> set, List<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            backtrack(nums, set, path);
            path.remove(path.size() - 1);
            set.remove(nums[i]);
        }
    }
}
