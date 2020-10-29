class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode* temp=head;
        int n=0;
        
        while(temp!=NULL){
            temp=temp->next;
            n++;
        }
        
        n=ceil(n/2);
        
        while(n--){
            head=head->next;
        } 
        return head; 
    }
};
