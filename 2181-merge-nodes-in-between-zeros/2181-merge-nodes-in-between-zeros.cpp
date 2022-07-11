/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeNodes(ListNode* head) {
        int sum = 0;
        
        ListNode *curr, *temp;
        curr = head->next;
        temp = head;
        
        while(curr != NULL) {
            if(curr->val == 0) {
                curr->val = sum;
                sum = 0;
                temp->next = curr;
                temp = curr;
            }
            else {
                sum += curr->val;
            }
            curr = curr->next;
        }
        
        return head->next;
    }
};