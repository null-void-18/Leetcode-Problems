//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
class Solution
{
    
    
    private:
    
    void findSum(int index,int n,int sum,vector<int> &arr,vector<int> &ans) {
        if(index == n) {
            ans.push_back(sum);
            return;
        }
        
        findSum(index+1,n,sum,arr,ans);
        findSum(index+1,n,sum+arr[index],arr,ans);
        
    }
    
    
public:
    vector<int> subsetSums(vector<int> arr, int N)
    {
        vector<int> ans;
        
        
        findSum(0,N,0,arr,ans);
        
        return ans;
    }
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin>>N;
        vector<int> arr(N);
        for(int i = 0 ; i < N ; i++){
            cin >> arr[i];
        }
        Solution ob;
        vector<int> ans = ob.subsetSums(arr,N);
        sort(ans.begin(),ans.end());
        for(auto sum : ans){
            cout<< sum<<" ";
        }
        cout<<endl;
    }
    return 0;
}
// } Driver Code Ends