class Solution {
public:
    string toLowerCase(string str) {
        for(int i=0;i<str.length();i++){
            if(str[i]<97) str[i]=tolower(str[i]);
        }
        return str;
    }
};
