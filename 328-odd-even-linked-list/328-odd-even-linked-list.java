/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        boolean flag = false;
        ListNode temp1 = odd;
        ListNode temp2 = even;
        
        ListNode temp = head;
        while(temp!=null){
            if(flag){
                temp2.next = temp;
                temp2 = temp;
                temp = temp.next;
                flag = false;
            }else{
                temp1.next = temp;
                temp1 = temp;
                temp = temp.next;
                flag = true;
            }        
        }
        temp1.next = even.next;
        temp2.next = null;
        return odd.next;
    }
}