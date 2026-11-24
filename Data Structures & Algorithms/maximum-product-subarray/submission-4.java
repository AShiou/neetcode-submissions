class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = maxProduct * nums[i];
            int tempMin = minProduct * nums[i];
            maxProduct = Math.max(nums[i], Math.max(tempMax, tempMin));
            minProduct = Math.min(nums[i], Math.min(tempMax, tempMin));
            result = Math.max(maxProduct, result);
        }
        return result;
    }
}
