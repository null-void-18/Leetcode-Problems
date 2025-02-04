//39. Combination Sum

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(ans,new ArrayList<>(),nums,target,0);
        return ans;
    }

    void helper(List<List<Integer>> ans, List<Integer> ls,int nums[],int target,int start) {
        if(target < 0) return;
        else if(target == 0) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        else {
            for(int i = start; i < nums.length;i++) {
                ls.add(nums[i]);
                helper(ans,ls,nums,target - nums[i],i);
                ls.remove(ls.size()-1);
            }
        }
    }
}
