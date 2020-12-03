class Solution {
public:
    string reverseParentheses(string s) {
        stack<pair<char,int>> st;
        
        for(int i=0;i<s.length();i++){
            if(s[i]=='('){
                st.push({'(',i});
            }
            else if(s[i]==')'){
                reverse(s.begin()+st.top().second+1,s.begin()+i);
                s.erase(i,1);
                s.erase(st.top().second,1);
                i=i-2;
                st.pop();
            }
        }
        return s;
    }
};
