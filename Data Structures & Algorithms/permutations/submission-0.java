class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new HashSet<>(), new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, Set<Integer> chosen, List<Integer> path, List<List<Integer>> result) {
        if (chosen.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (chosen.contains(nums[i])) {
                continue;
            }
            chosen.add(nums[i]);
            path.add(nums[i]);
            backtrack(nums, chosen, path, result);
            int val = path.remove(path.size() - 1);
            chosen.remove(val);
        }
    }
}
