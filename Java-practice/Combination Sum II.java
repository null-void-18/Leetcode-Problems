
class Solution {
    
    static void dfs(ArrayList<ArrayList<Integer>> ans, List<Integer> temp, int arr[], int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp)); // Found a valid combination
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue; // Skip duplicates
            
            if (arr[i] > target) break; // No need to continue if current element exceeds target
            
            temp.add(arr[i]);
            dfs(ans, temp, arr, target - arr[i], i + 1); // Move to next index
            temp.remove(temp.size() - 1); // Backtrack
        }
    }

    static ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr); // Sorting ensures duplicate elements are handled correctly
        dfs(ans, new ArrayList<>(), arr, target, 0);
        return ans;
    }
}
