class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int prevMax = maxProd;
            int prevMin = minProd;

            maxProd = Math.max(nums[i], Math.max(prevMax * nums[i], prevMin * nums[i]));
            minProd = Math.min(nums[i], Math.min(prevMax * nums[i], prevMin * nums[i]));
            max = Math.max(maxProd, max);
        }
        return max;
    }
}
