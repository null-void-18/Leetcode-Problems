class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        vector<int> ans(T.size(),0);
        
        stack<pair<int,int>> st;
        
        for(int i=0;i<T.size();i++){
            while(!st.empty() and T[i]>st.top().first){
                ans[st.top().second]=i-st.top().second;
                st.pop();
            }
            st.push({T[i],i});
        }
        return ans;
    }
};
