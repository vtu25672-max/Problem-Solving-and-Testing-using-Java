class Solution {
    public int[] runningSum(int[] nums) {
        // Start from index 1 because the running sum at index 0 
        // is always just nums[0].
        for (int i = 1; i < nums.length; i++) {
            // Update the current element by adding the sum of all previous elements
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
