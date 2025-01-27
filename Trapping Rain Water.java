//42. Trapping Rain Water

//Optimal solution
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int leftmax = 0;
        int rightmax = 0;
        int ans = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                if(leftmax <= height[left]) {
                    leftmax = height[left];
                }
                else {
                    ans += (leftmax - height[left]);
                }
                left++;
            }else {
                if(rightmax <= height[right]) {
                    rightmax = height[right];
                }
                else {
                    ans += (rightmax - height[right]);
                }
                right--;
            }
        }
            return ans;
        }
    }




//Original Solution
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        if(n == 0 || n == 1 || n == 2) {
            return 0;
        }
        int count = 0;
        left[0] = height[0];
        right[n-1] = height[n-1];
        for(int i =1;i < height.length;i++) {
            left[i] = Math.max(height[i],left[i-1]);
        }
        right[n-1] = height[n-1];
        for(int i =n-2;i >= 0;i--) {
            right[i] = Math.max(height[i],right[i+1]);
        }

        for(int i = 0; i < n;i++) {
            count += Math.min(left[i],right[i]) - height[i];
        }
        return count;
    }
}
