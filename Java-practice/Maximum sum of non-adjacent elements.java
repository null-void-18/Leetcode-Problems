
public class Solution {

	static int helper(ArrayList<Integer> nums,int[] dp,int len,int start) {
		if(start >= len) {
			return 0;
		}
		if(dp[start] != -1) return dp[start];
		return dp[start] = Math.max(nums.get(start) + helper(nums,dp,len,start+2), helper(nums,dp,len,start+1));
	}



	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();
		if(n == 1) return nums.get(0);
		int dp[] = new int[n];
		Arrays.fill(dp,-1);
		if(n == 2) return Math.max(nums.get(0),nums.get(1));
		dp[0] = nums.get(0);
		dp[1] = Math.max(nums.get(0),nums.get(1));


		for(int i = 2;i < n;i++) {
			dp[i] = Math.max(nums.get(i) + dp[i-2], dp[i-1]);
		}
		return dp[n-1];
	}
}
