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
    ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {
        ListNode* ll = list2;
        while(ll->next!=NULL)ll = ll->next;
        int count = 0;
        ListNode* temp = list1;
        while(count != a-1){
            temp = temp->next;
            count++;
        }
        ListNode* move = temp->next;
        temp->next = list2;
        while(count!=b){move=move->next;count++;}
        ll->next = move;
        return list1;
        
        
        
    }
};