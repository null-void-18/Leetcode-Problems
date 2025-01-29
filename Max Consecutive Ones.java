//485. Max Consecutive Ones


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, result = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                result = Math.max(count, result);
                count = 0;
            }
            else count++;
        }
        return Math.max(count, result);
    }
}
