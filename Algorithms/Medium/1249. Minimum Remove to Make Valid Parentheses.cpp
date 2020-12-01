class Solution {
public:
    string minRemoveToMakeValid(string s) {
        int left = 0, valid = 0, right = 0;
        
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                left++;
            } else if (s[i] == ')' && valid < left) {
                valid++;
            }
        }
        
        left = 0;
        string ret = "";
        for (int i = 0; i < s.size(); i++) {
            if (isalpha(s[i])) {
                ret.push_back(s[i]);
            } else if (s[i] == '(' && left < valid) {
                ret.push_back(s[i]);
                left++;
            } else if (s[i] == ')' && right < left) {
                ret.push_back(s[i]);
                right++;
            }
        }
        return ret;
        
    }
};
