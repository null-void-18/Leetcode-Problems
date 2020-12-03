class Solution {
public:
    int mctFromLeafValues(vector<int>& arr) {
        stack<int> st;
        int ans=0;
        
        for(int i:arr){
            while(!st.empty() and st.top()<=i){
                int n=st.top();
                st.pop();
                ans+=n*min(st.empty()?INT_MAX:st.top(),i);
            }
            st.push(i);
        }
        int n=st.top();
        
        st.pop();
        while(!st.empty()){
            int k=st.top();
            st.pop();
            ans+=k*min(st.empty()?INT_MAX:st.top(),n);
            n=k;
        }
        return ans;
    }
};
