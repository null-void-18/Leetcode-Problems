class Solution {
public:
    int scoreOfParentheses(string S) {
        stack<int> s;
        s.push(0);
        for(int i=0;i<S.length();++i){
            if(S[i]=='(') s.push(0);
            else{
                int v=s.top();
                s.pop();
                int w=s.top();
                s.pop();
                s.push(w+max(2*v,1));
            }
        }
        return s.top();
    }
};
