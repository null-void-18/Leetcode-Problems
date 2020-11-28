class Solution {
public:
    string removeDuplicates(string S) {
        string ans = "";
        for(auto c: S) {
            if(!ans.empty() && ans.back() == c)
                ans.pop_back();
            else ans.push_back(c);
        }
        return ans;
    }
};
