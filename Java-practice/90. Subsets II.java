

//Backtracking


class Solution {

    public void helper(List<List<Integer>> ans, List<Integer> temp, int arr[], int start) {
        ans.add(new ArrayList<>(temp));

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue; 
            }
            temp.add(arr[i]);
            helper(ans, temp, arr, i + 1);
            temp.remove(temp.size() - 1);  
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);  
        helper(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
}
