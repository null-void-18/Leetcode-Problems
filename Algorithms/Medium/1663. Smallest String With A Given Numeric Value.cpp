class Solution {
public:
    string getSmallestString(int n, int k) {
        k-=n;
        string s(n,'a');
        for(int i=n-1;i>=0;i--){
            if(k<=0) break;
            if(k>25){
                s[i]='a'+25;
                k-=25;
                continue;
            }
            else{
                s[i]='a'+k;
                break;
            }
        }
        return s;
    }
};
