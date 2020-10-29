class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* temp=head;
        int m=0;
        
        while(temp!=NULL){
            temp=temp->next;
            m++;
        }
        if(m==1 and n==1){
            return NULL;
        }
        if(m==n){
            head=head->next;
            return head;
        }
        m-=n;
        if(m) m--;
        
        temp=head;
        
        while(m--){
            temp=temp->next;
        }
        
        if(m){
            if(temp->next->next!=NULL){
            temp->next=temp->next->next;
            }
            else{
            temp->next=NULL;
            }
        }
        return head;
        
    }
};
