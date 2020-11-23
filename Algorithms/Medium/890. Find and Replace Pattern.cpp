class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        unordered_map<char, char> mapping;
        set<char> dup;
        vector<string> ans;
        for (const auto& word : words)
        {
            mapping.clear();
            dup.clear();
            if (word.size() != pattern.size()) continue;
            int i = 0;
            for (i = 0; i < word.size(); i++)
            {
                if (!mapping.count(pattern[i]) && !dup.count(word[i]))
                {
                    mapping[pattern[i]] = word[i];
                    dup.insert(word[i]);
                }
                else
                {
                    if (mapping[pattern[i]] != word[i])
                        break;
                }
            }   
            if (i == word.size()) ans.push_back(word);
        }    
        return ans;
    }
};
