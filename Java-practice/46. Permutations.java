//46. Permutations

class Solution {
    public void helper(List<List<Integer>> ans, ArrayList<Integer> temp, int nums[], boolean[] used) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true; 
                temp.add(nums[i]); 
                helper(ans, temp, nums, used);
                temp.remove(temp.size() - 1); 
                used[i] = false; 
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        helper(ans, new ArrayList<>(), nums, used);
        return ans;
    }
}
