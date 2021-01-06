class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {        
        ListNode dummy(-101), *p = head, *p2=&dummy;        
        while(p){
            ListNode *l = p, *r = p->next;            
            while(r && l->val == r->val) r = r->next;                            
            if(l->next == r){ 
                p2->next = l;
                p2 = p2->next;
                p2->next = NULL; 
            }
            p = r;            
        }
        return dummy.next;
    }
};
