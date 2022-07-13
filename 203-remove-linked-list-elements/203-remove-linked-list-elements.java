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
    public ListNode removeElements(ListNode head, int val) {
        
        if(head==null)return null;
        if(head.next == null && head.val == val)return null;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null){
            
            if(curr.val == val){
                ListNode temp = curr.next;
                prev.next = curr.next;
                curr = temp;
            }else{
                prev =curr;
                curr = curr.next;
            }
        }
        
        
        
        
        return dummy.next;
    }
}