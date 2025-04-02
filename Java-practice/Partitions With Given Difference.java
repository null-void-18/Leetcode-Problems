


//DP solution


public class Solution {

	final static int modulo = 1000000007;

	public static int countPartitions(int n, int d, int[] arr) {
		int totalSum = 0;
		for (int i : arr) {
			totalSum += i;
		}
		
		if ((totalSum + d) % 2 != 0 || totalSum < d) {
			return 0;
		}

		int targetSum = (totalSum + d) / 2;

		int dp[][] = new int[n + 1][targetSum + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= targetSum; j++) {
				dp[i][j] = dp[i - 1][j];
				
				if (j - arr[i - 1] >= 0) {
					dp[i][j] = (dp[i][j] + dp[i - 1][j - arr[i - 1]]) % modulo;
				}
			}
		}

		return dp[n][targetSum];
	}
}





//Recursive with memoization solution

public class Solution {

	final static int modulo = 1000000007;



	private static int calculate(int totalSum,int n,int d,int arr[],int dp[][]) {
		if(n < 0) {
			if(totalSum == d) {
				return 1;
			}
			return 0;
		}

		if(dp[totalSum][n] != -1) return dp[totalSum][n];

		int notTake = calculate(totalSum,n-1,d,arr,dp);
		int take = calculate(totalSum-arr[n],n-1,d,arr,dp);

		return dp[totalSum][n] = (take + notTake) % modulo;
	}


	public static int countPartitions(int n, int d, int[] arr) {
		int totalSum = 0;
		for(int i : arr) {
			totalSum += i;
		}
		if((totalSum + d) % 2 != 0) return 0;
		int dp[][] = new int[totalSum + 1][n];
		for(int row[]: dp) {
			Arrays.fill(row,-1);
		}
		return calculate(totalSum,n-1,(totalSum + d)/2,arr,dp);
	}
}
