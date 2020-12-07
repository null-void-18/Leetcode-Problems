class Solution {
public:
    vector<string> ans;
    
    void preorder(string s){
        stringstream ss(s);
        string tok;
        while(getline(ss,tok,',')){
            ans.push_back(tok);
        }
    }
    
    bool isValidSerialization(string p) {
        preorder(p);
        int count=1;
        for(auto i:ans){
            count--;
            if(count<0) return 0;
            
            if(i!="#") count+=2;
        }
        return count==0;
    }
};
