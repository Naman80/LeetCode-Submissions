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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mainhead = reverseList(head.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = null;
        return mainhead;
        // ListNode prev = null;
        // ListNode curr = head;
        // while(curr!=null){
        //     ListNode temp = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr=temp;
        // }
        // return prev;
    }
}