class Solution {
    public int[] productExceptSelf(int[] nums) {
        // for loop and multiply, for loop again and division
        // use prefix and suffix
        int[] res = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int val = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = val;
            val = val * nums[i];
        }
        val = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = val;
            val = val * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}  
