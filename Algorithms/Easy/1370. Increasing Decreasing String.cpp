class Solution {
public:
    string sortString(const string& s) {
        const int len=26;
        
        vector<int> v(len);
        for(auto i:s) ++v[i-'a'];
        
        string res;
        while(res.size()<s.size()) {
            
            for(int i=0; i<len; ++i)
                if(v[i]) {res+=i+'a'; --v[i];}
            
            for(int i=len-1; i>-1; --i)
                if(v[i]) {res+=i+'a'; --v[i];}
        }
        return res;
    }
};
