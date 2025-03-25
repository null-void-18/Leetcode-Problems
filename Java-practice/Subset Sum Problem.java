








//Recursion with Memoization 


class Solution {
    
    static int calculate(int start,int end,int sum,int dp[][],int arr[]) {
        if(sum == 0) return 1;
        if(sum < 0 || start == end) return 0;
        if(dp[start][sum] != -1) return dp[start][sum];
        return dp[start][sum] = (calculate(start+1,end,sum,dp,arr) | calculate(start+1,end,sum-arr[start],dp,arr));
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        int dp[][] = new int[n][sum+1];
        for(int row[]: dp) {
            Arrays.fill(row,-1);
        }
        int ans = calculate(0,arr.length,sum,dp,arr);
        return ans == 0? false:true;
    }
}





//Exponential approach


class Solution {

    static boolean findSubset(int arr[],int target,int start,int length) {
        if(start >= length || target < 0) {
            return false;
        }
        if(target == 0) {
            return true;
        }
        
        return (findSubset(arr,target,start + 1,length) || findSubset(arr,target - arr[start],start + 1,length));
        
    }


    static Boolean isSubsetSum(int arr[], int target) {
        return findSubset(arr,target,0,arr.length);
    }
}
