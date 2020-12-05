class Solution {
public:
    string entityParser(string text) {
        string s;
        stack<string> st;
        int i=0,j=0;
        while(i<text.size()){
            if(text[j]=='&'){
                s += text.substr(i,j-i);
                i=j;
            }
            if(text[j]=='\0' || text[j]==';'){
                    st.push(text.substr(i,j-i+1));
                    if(st.top()=="&quot;") s+='\"';
                    
                    else if(st.top()=="&apos;") s+="\'";
                    
                    else if(st.top()=="&amp;") s+="&";
                    
                    else if(st.top()=="&gt;") s+=">";
                
                    else if(st.top()=="&lt;") s+="<";
                    
                    else if(st.top()=="&frasl;") s+="/";
                    
                    else s+=st.top();
                    
                    i=j+1; 
            }
            j++;
        }
        return s;
    }
};
