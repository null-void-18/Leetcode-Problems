
class Solution {
public:
    Node* connect(Node* root) {
        if(!root) return NULL;
        
        queue<Node*> q;
        
        q.push(root);
        int size=1;
        
        while(!q.empty()){
            int temp=0;
            
            for(int i=0;i<size;i++){
                auto node=q.front();
                q.pop();
                
                if(i<size-1) node->next=q.front();
                else node->next=NULL;
                
                if(node->left){
                    temp++;
                    q.push(node->left);
                }
                if(node->right){
                    temp++;
                    q.push(node->right);
                }
            }
            size=temp;
        }
        return root;
    }
};
