class Solution {
public:
    vector<int> partitionLabels(string S) {
        int last[26];
        int n=S.length();
        for(int i=0;i<n;++i){
            last[S[i]-'a']=i;
        }
        
        vector<int> a;
        int j=0,anchor=0;
        for(int i=0;i<n;++i){
            j=max(j,last[S[i]-'a']);
            if(i==j){
                a.push_back(i-anchor+1);
                anchor=i+1;
            }
        }
        return a;
    }
};
