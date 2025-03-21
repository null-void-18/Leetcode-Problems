
//Dp Aproach

class Solution {
public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) return 0;

    int m = triangle.size();
    int[][] dp = new int[m][m];

    dp[0][0] = triangle.get(0).get(0);

    for (int i = 1; i < m; i++) {
        for (int j = 0; j < triangle.get(i).size(); j++) {
            int fromAbove = j < triangle.get(i - 1).size() ? dp[i - 1][j] : Integer.MAX_VALUE;
            int fromLeft = j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
            dp[i][j] = triangle.get(i).get(j) + Math.min(fromAbove, fromLeft);
        }
    }

    int minTotal = Integer.MAX_VALUE;
    for (int val : dp[m - 1]) {
        minTotal = Math.min(minTotal, val);
    }

    return minTotal;
}
}



//Recursion with Memoization

class Solution {

    int calculate(int i,int m,int dp[][],List<List<Integer>> triangle) {
        if(m < 0 || i >= triangle.get(m).size() || i < 0) return Integer.MAX_VALUE;
        if(m == 0) return triangle.get(0).get(0);
        if(dp[m][i] != Integer.MAX_VALUE) return dp[m][i];
        int left = calculate(i,m-1,dp,triangle);
        int right = calculate(i-1,m-1,dp,triangle);
        if(left == Integer.MAX_VALUE && left == right) {
            return dp[m][i] = triangle.get(m).get(i);
        }
        return dp[m][i] = triangle.get(m).get(i) + Math.min(left,right);
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        int m = triangle.size();
        int dp[][] = new int[m][m];

        for(int row[]: dp) {
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        for(int i = 0;i < m;i++) {
            ans = Math.min(ans,calculate(i,m-1,dp,triangle));
        }
        return ans;
    }
}
