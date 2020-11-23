class Solution {
public:
    string reverseWords(string s) {
        string t=s;
        int k=0;
        for(int i=0;i<s.length();i++){
            if(s[i] ==' '){
                reverse(t.begin()+k,t.end()-s.length()+i);
                k=i+1;
            }
        }
        reverse(t.begin()+k,t.end());
        return t;
    }
};
