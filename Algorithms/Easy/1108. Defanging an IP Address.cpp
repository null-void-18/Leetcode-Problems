class Solution {
public:
    string defangIPaddr(string address) {
        string s;
        queue<char> res;
        for(int i=0;i<address.length();i++){
            res.push(address[i]);
        }
        while(!res.empty()){
            if(res.front() == '.'){
                s=s+'['+'.'+']';
                res.pop();
            }
            s+=res.front();
            res.pop();
        }
        return s;
    }
};
