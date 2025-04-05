


//DP Approach



public class Solution {


	public static int cutRod(int price[], int n) {
		int dp[][] = new int[n+1][n+1];

		for(int row[] : dp) {
			Arrays.fill(row,0);
		}

		for(int i = 0; i <= n;i++) {
			dp[1][i] = i * price[0];
		}


		for(int i = 2; i <= n;i++) {
			for(int j = 1; j <= n;j++) {
						
				int take = 0;
				if(j - i >= 0) {
					take = price[i-1] + dp[i][j-i];
				}

				int notTake = dp[i-1][j];

				dp[i][j] = Math.max(take,notTake);
			}
		}



		return dp[n][n];
	}
}





//Recursion with Memoization

public class Solution {

	private static int calculate(int start,int n,int price[],int dp[][]) {
		if(n == 0 || start > n) return 0;

		if(dp[start][n] != -1) return dp[start][n];

		int take = 0;
		if(n - start >= 0) {
			take = price[start-1] + calculate(start,n-start,price,dp);
		}

		int notTake = calculate(start+1,n,price,dp);

		return dp[start][n] = Math.max(take,notTake);
	}



	public static int cutRod(int price[], int n) {
		int dp[][] = new int[n+1][n+1];

		for(int row[] : dp) {
			Arrays.fill(row,-1);
		}

		return calculate(1,n,price,dp);
	}
}
