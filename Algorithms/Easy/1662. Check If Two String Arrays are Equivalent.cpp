class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        string s,t;
        
        for(string i:word1) s+=i;
        for(string i:word2) t+=i;
        return (s==t)?true:false;
    }
};
