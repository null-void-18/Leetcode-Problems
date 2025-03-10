





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
