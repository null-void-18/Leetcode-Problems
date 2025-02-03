//Subset Sums




//Recursive Solution

class Solution {
    ArrayList<Integer> ans = new ArrayList<Integer>();;
    
    void findAllSubsets(int arr[],int len,int sum) {
        if(len < 0) {
            ans.add(sum);
            return;
        }
        findAllSubsets(arr,len - 1,sum + arr[len]);
        findAllSubsets(arr,len - 1,sum);
    }
    
    
    public ArrayList<Integer> subsetSums(int[] arr) {
        
        findAllSubsets(arr,arr.length - 1,0);
        return ans;
    }
}
