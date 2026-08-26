class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> indexDeque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int right = 0; right < nums.length; right++) {
            // 1. 移除過期
            if (!indexDeque.isEmpty() && indexDeque.peekFirst() < right - k + 1) {
                indexDeque.pollFirst();
            }
            // 2. 比新的還小的都刪除
            while (!indexDeque.isEmpty() && nums[right] >= nums[indexDeque.peekLast()]) {
                indexDeque.pollLast();
            }
            // 3. 加入新的
            indexDeque.offerLast(right);
            // 4. 紀錄 result
            if (right + 1 >= k) {
                result[right + 1 - k] = nums[indexDeque.peekFirst()];
            }
        }
        return result;
    }
}
