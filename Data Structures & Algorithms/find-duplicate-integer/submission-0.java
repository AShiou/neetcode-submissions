class Solution {
    public int findDuplicate(int[] nums) {
        // method1: hashset, if exists, then return
        // method2: withoud modify nums and use O(1) extra space
        // Floyd's cycle detection
        // step1: 找到相遇點
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // step2: 找 entrance
        // 假設 start 到 entrance 是 a
        // entrance 到相遇點是 ｂ
        // 相遇點到 entrance 是 c
        // slow 走 a+b, fast 走 2(a+b)
        // 2(a+b) = a + k(b+c)
        // a = (k-1)(b+c) + c
        // 如果 slow 從 start 走 a, fast 從相遇點走 c，遇到的點是 entrance
        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
