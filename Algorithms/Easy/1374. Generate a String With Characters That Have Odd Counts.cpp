class Solution {
public:
    string generateTheString(int n) {
        string s(n,'a');
        if(!(n%2)) s[n-1]='b';
        return s;
    }
};
