class Solution {
public:
    string simplifyPath(string path) {
        
        stack<string> st;
        stringstream ss(path);
        string buff;
        while(getline(ss,buff,'/'))
        {
            if(buff.size()>0)
            {
                if(buff==".")
                    continue;
                else if(buff=="..")
                {
                    if(st.size())
                        st.pop();
                }
                else
                {
                    st.push(buff);
                }
            }
        }
        
       string res = "";
        while(st.size())
        {
            res = "/" + st.top() + res;
            st.pop();
        }
        if(res=="") return "/";
        
        return res;
        
    }
};
