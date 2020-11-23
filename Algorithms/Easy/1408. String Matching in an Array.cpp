class Solution {
public:
    vector<string> stringMatching(vector<string>& w) {
       
        vector<string> s;
        
        for(int i=0;i<w.size();i++)
        {
            for(int j=0;j<w.size();j++)
            {
                if(j==i || w[i].size()>w[j].size())
                    continue;
                
                if(w[j].find(w[i]) !=-1)
                { s.push_back(w[i]); 
                   break;
                }
            }
        }
        return s;
    }
};
