/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode temp = headA;
        int l1 = 0;
        while(temp!=null){
            l1++;
            temp = temp.next;
        }
        int l2 = 0 ;
        temp = headB;
        while(temp!=null){
            l2++;
            temp = temp.next;
        }
        int d;
        ListNode temp2 ;
        if(l2>l1){
            d = l2 -l1;
            temp = headB;
            temp2 = headA;
        }else{
            d = l1 - l2;
            temp = headA;
            temp2 = headB;
        }
        
        while(d-- > 0){
            temp = temp.next;
        }
        
        while(temp != null){
            if(temp == temp2) return temp;
            temp = temp.next;
            temp2 = temp2.next;
        }
        
        return null;
    }
}