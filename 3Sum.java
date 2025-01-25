//15. 3Sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0;i < nums.length;i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1, k = nums.length - 1;

            while(j < k) {
                int ans = nums[i] + nums[j] + nums[k];
                if(ans > 0) {
                    k -= 1;
                }
                else if(ans < 0) {
                    j += 1;
                }
                else{
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
