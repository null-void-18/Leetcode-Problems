class Solution {
public:
    vector<int> mostCompetitive(vector<int>& a, int k) {
        const int n = a.size();
        vector<int> ans;
        for (int i = 0; i < n; ++i) {
            while (ans.size() > 0 && a[i] < ans.back() && int(ans.size()) - 1 + (n - i) >= k) {
                ans.pop_back();
            }
            if (ans.size() < k) ans.push_back(a[i]);
        }
        return ans;
    }
};
