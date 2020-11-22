class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        vector<string> morse={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        set<string> s;
        for(int i=0;i<words.size();i++){
            string t;
            for(int j=0;j<words[i].size();j++){
                int k=words[i][j];
                t+=morse[k-97];
            }
            s.insert(t);
        }
        return s.size();
    }
};
