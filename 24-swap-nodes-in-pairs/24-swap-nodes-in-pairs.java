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
    public ListNode swapPairs(ListNode head) {
     if(head==null || head.next == null)return head;
        
        ListNode dummy = new ListNode(-1);
        
        dummy.next = head;
        ListNode prev = dummy;
        ListNode temp = head;
        
        ListNode curr = head.next;
        
        
        while(temp!=null && curr!=null){
            ListNode forw = curr.next;
            prev.next = curr;
            curr.next = temp;
            temp.next = forw;
            temp = forw;
            if(temp!=null)curr = temp.next;
            prev = prev.next.next;
        }
        
        return dummy.next;
        
        
        
    }
}