

//

class Solution {
    public int subarraySum(int[] nums, int k) {
        return calculate(nums, 0, 0, k);
    }

    private int calculate(int[] nums, int start, int currentSum, int k) {
        // Base case: If we've processed all elements
        if (start == nums.length) {
            return 0;
        }
        
        int result = 0;
        // Traverse the array from current 'start' to the end, accumulating the sum
        for (int i = start; i < nums.length; i++) {
            currentSum += nums[i];
            
            // If the current sum matches k, we found a subarray
            if (currentSum == k) {
                result++;
            }
        }
        
        // Continue with the next element and try to find more subarrays starting from there
        return result + calculate(nums, start + 1, 0, k);
    }
}
