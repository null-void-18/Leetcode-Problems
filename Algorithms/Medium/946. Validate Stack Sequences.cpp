class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int> s;
        int i=0,j=0,m=pushed.size(),n=popped.size();
        
        while(i<m and j<n){
            if(!s.empty()){
                if(s.top()==popped[j]){
                    s.pop();
                    j++;
                }
                else{
                    s.push(pushed[i]);
                    i++;
                }
            }
            else{
                s.push(pushed[i]);
                i++;
            }
        }
        
        if(j==n and i!=m) return false;
        if(j!=n){
            while(!s.empty()){
                if(s.top()==popped[j]){
                    s.pop();
                    j++;
                }
                else break;
            }
        }
        
        return s.size()==0;
        
        
    }
};
