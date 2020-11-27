class Solution {
public:
    bool detectCapitalUse(string word) {
        int capital=0;
        
        for(int i=0;i<word.length();i++){
            if(isupper(word[i])) capital++;
        }
        
        if(capital == word.length()) return true;
        else if(capital==1 and isupper(word[0])) return true;
        
        return capital==0;
    }
};
