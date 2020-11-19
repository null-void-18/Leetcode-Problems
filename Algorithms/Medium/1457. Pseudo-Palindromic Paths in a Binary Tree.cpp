class Solution {
public:
    bool canpalindrome(string s){
        int l=s.length();
        map<char,int> m;
        for(int i=0;i<l;i++){
            m[s[i]]++;
        }
        int odd=0;
        for(auto it=m.begin();it!=m.end();it++){
            if(it->second%2!=0) odd++; 
        }
        if(odd>1) return false;
        return true;
    }
    
    void paths(TreeNode* p,string s,int &count){
        if(p==NULL) return;
        s+=to_string(p->val);
        if(p->left==NULL and p->right==NULL){
            if(canpalindrome(s)) count++;
        }
        paths(p->left,s,count);
        paths(p->right,s,count);
    }
    
    int pseudoPalindromicPaths(TreeNode* root) {
        int count=0;
        string s="";
        paths(root,s,count);
        return count;
    }
};
