class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        set<string> s;
        
        for(int i=0;i<emails.size();i++){
            string t;
            int flag=0,plus=0;
            for(int j=0;j<emails[i].length();j++){
                if(emails[i][j]=='@'){
                    t+='@';
                    flag=1;
                    plus=0;
                    continue;
                }
                if(plus) continue; 
                if(!flag and emails[i][j]=='.'){
                    continue;
                }
                if(!flag and emails[i][j]=='+'){
                    plus=1;
                    continue;
                }
                t+=emails[i][j];
            }
            s.insert(t);
        }
        return s.size();
    }
};
