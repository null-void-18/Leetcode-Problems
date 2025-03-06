
class Solution {
    
    static void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int arr[],
                       int target, int sum, int start) {
        if (sum == target) {
            ans.add(new ArrayList<>(temp)); // Store a snapshot of temp
            return;
        }
        
        if (sum > target || start >= arr.length) {
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue;

            if (sum + arr[i] <= target) {
                temp.add(arr[i]);
                helper(ans, temp, arr, target, sum + arr[i], i); // Allow same element reuse
                temp.remove(temp.size() - 1); // Backtrack
            }
        }
    }
    
    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
        Arrays.sort(arr); // Sorting helps to skip duplicates
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), arr, target, 0, 0);
        return ans;
    }
}
