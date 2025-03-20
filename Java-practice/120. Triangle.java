
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
