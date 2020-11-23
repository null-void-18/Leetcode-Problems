class Solution {
public:
    string complexNumberMultiply(string a, string b) {
        string p="",q="",r="",t="";
        int i=0;
        while(a[i]!='+'){
            p+=a[i++];
        }
        i++;
        while(a[i]!='i'){
            q+=a[i++];
        }
        i=0;
        while(b[i]!='+'){
            r+=b[i++];
        }
        i++;
        while(b[i]!='i'){
            t+=b[i++];
        }
        int a1=stoi(p),a2=stoi(r),b1=stoi(q),b2=stoi(t);
        int x=(a1*a2)-(b1*b2),y=(a1*b2+a2*b1);
        return to_string(x)+'+'+to_string(y)+'i';
    }
};
