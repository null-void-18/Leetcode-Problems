class Solution {
public:
    bool canReach(vector<int>& arr, int s) {
        if(s>=0 and s<arr.size() and arr[s]>=0){
            if(arr[s] == 0) return true;
            arr[s]=-arr[s];
            return (canReach(arr,s+arr[s]) || canReach(arr,s-arr[s]));
        }
        return false;
    }
};
