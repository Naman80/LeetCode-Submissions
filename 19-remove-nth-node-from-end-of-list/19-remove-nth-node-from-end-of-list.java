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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        
        
        ListNode temp = head;
        
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        
        
        int back = count - n;
        
        if(back==0){head = head.next;return head;}
        // System.out.println(back + " " + count);
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(back-- > 0){
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = curr.next;
        
        return head;
        
        
    }
}