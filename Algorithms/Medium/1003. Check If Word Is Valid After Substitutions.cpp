class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(int i=0;i<s.length();i++){
            if(s[i]=='c'){
                if(st.size()<2) return false;
                char b=st.top();st.pop();
                char a=st.top();st.pop();
                if(b!='b' or a!='a') return false;
            }
            else st.push(s[i]);
        }
        return st.empty();
    }
};
