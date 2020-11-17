class Solution {
public:
    int maxLevel = 0;
    void dfsNary(Node *root,int currLevel) { 
        if(!root) return; 
        
        for(auto i : root->children) {  
            dfsNary(i,currLevel + 1);
            maxLevel = max(currLevel,maxLevel);
        }
    }
    int maxDepth(Node* root) {   
        if(!root) return 0;
        if(root->children.empty()) return 1;
        dfsNary(root,2);
        return maxLevel; 
    }
};
