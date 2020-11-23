class Solution {
public:
    int isPrefixOfWord(string sentence, string searchword) {
        int ans=0;
        string t;
        stringstream s(sentence);
        
        while(s >> t){
            ++ans;
            int flag=0;
            if(t.length() < searchword.length()) continue;
            for(int i=0;i<searchword.length();i++){
                if(t[i]!=searchword[i]){
                    flag=1;
                    break;
                }
            }
            if(!flag) return ans;
        }
        return -1;
    }
};
