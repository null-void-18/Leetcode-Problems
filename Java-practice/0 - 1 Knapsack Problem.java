

//DP + space optimized


class Solution {
    
    
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int prev[] = new int[W+1];
        int curr[] = new int[W+1];
        
        for(int i = 0; i <= W;i++) {
            if(wt[0] <= i) {
                prev[i] = val[0];
            }
            else {
                prev[i] = 0;
            }
        }
        
        
        for(int i = 1;i < n;i++) {
            for(int j = 1;j <= W;j++) {
                int take = 0;
                int notTake = prev[j];
                if(j >= wt[i]) {
                    take = prev[j-wt[i]] + val[i];
                }
                curr[j] = Math.max(take,notTake);
            }
            prev = curr.clone();
        }
        
        return prev[W];
    }
}





//Dp Approach




class Solution {
    
    
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int dp[][] = new int[n][W+1];
        for(int row[]: dp) {
            for(int i = 0; i < row.length; i++) {
                row[i] = 0;
            }
        }
        
        for(int i = 0; i <= W;i++) {
            if(wt[0] <= i) {
                dp[0][i] = val[0];
            }
        }
        
        
        for(int i = 1;i < n;i++) {
            for(int j = 1;j <= W;j++) {
                int take = 0;
                int notTake = dp[i-1][j];
                if(j >= wt[i]) {
                    take = dp[i-1][j-wt[i]] + val[i];
                }
                dp[i][j] = Math.max(take,notTake);
            }
        }
        
        return dp[n-1][W];
    }
}






//Memoization


class Solution {
    
    static int calculate(int n,int W,int dp[][],int val[],int wt[]) {
        if(n == 0) {
            if(W >= wt[0]) {
                return val[0];
            } 
            return 0;
        }
        if(dp[n][W] != -1) return dp[n][W];
        int take = 0;
        int notTake = calculate(n-1,W,dp,val,wt);
        if(W >= wt[n]) {
            take = calculate(n-1,W-wt[n],dp,val,wt) + val[n];
        }
        return dp[n][W] = Math.max(take,notTake);
    }
    
    
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int dp[][] = new int[n][W+1];
        for(int row[]: dp) {
            for(int i = 0; i < row.length; i++) {
                row[i] = -1;
            }
        }

        return calculate(val.length-1,W,dp,val,wt);
    }
}




//Recursion Approach

class Solution {
    
    static int calculate(int n,int W,int val[],int wt[]) {
        if(n == 0) {
            if(W >= wt[0]) {
                return val[0];
            } 
            return 0;
        }
        int take = 0;
        int notTake = calculate(n-1,W,val,wt);
        if(W >= wt[n]) {
            take = calculate(n-1,W-wt[n],val,wt) + val[n];
        }
        return Math.max(take,notTake);
    }
    
    
    static int knapsack(int W, int val[], int wt[]) {
        return calculate(val.length-1,W,val,wt);
    }
}
