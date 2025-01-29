//26. Remove Duplicates from Sorted Array


class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = 0;
        int k = nums.length;
        int currValue = nums[0];
        for(int i = 1;i < k;i++) {
            if(nums[i] == currValue) {
                continue;
            }
            currValue = nums[i];
            curr++;
            nums[curr] = currValue;
        }
        return curr + 1;
    }
}
