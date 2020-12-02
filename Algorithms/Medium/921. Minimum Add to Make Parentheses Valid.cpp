class Solution {
public:
    int minAddToMakeValid(string S) {
        int ans=0;
        stack<char> st;
        for(int i=0;i<S.length();i++){
            if(S[i]=='(') st.push(S[i]);
            else{
                if(!st.empty()){
                    st.pop();
                }
                else ans++;
            }
        }
        while(!st.empty()){
            st.pop();
            ans++;
        }
        return ans;
    }
};
