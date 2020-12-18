class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(!head) return false;
        
        ListNode* t=head,*h=head->next;
        
        while(t!=h){
            if(!h or !h->next) return false;
            
            t=t->next;
            h=h->next->next;
        }
        return true;
    }
};
