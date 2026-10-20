class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = 1001;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                result = Math.min(result, nums[mid]);
                right = mid - 1;
            }
        }
        return result;
    }
}
