class Solution {
public:
    Node* dfs(Node* head){
        while(head->next) head=head->next;
        return head;
    }
    
    Node* flatten(Node* head) {
        if(!head) return nullptr;
        
        if(head->child){
            Node* tail=dfs(head->child);
            tail->next=head->next;
            head->child->prev=head;
            if(head->next) head->next->prev=tail;
            head->next=head->child;
            head->child=nullptr;
        }
        
        head->next=flatten(head->next);
        return head;
    }
};
