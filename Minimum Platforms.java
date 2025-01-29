//Minimum Platforms


class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 0;
        int j = 0;
        int ans = 0;
        int platform = 0;
        
        while(i < n && j < n) {
            if(arr[i] <= dep[j]) {
                platform += 1;
                ans = Math.max(ans,platform);
                i += 1;
            }
            else {
                platform -= 1;
                j += 1;
            }
        }
        
        
        return ans;
    }
}
