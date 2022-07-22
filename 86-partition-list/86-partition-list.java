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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next == null)return head;
        ListNode less = new ListNode(-1);
        ListNode more = new ListNode(-1);
        ListNode temp_less = less;
        ListNode temp_more = more;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val < x){
                temp_less.next = temp;
                temp_less = temp_less.next;
            }else{
                temp_more.next = temp;
                temp_more = temp_more.next;
            }
            temp = temp.next;
        }
        temp_more.next = null;
        temp_less.next = more.next;
        return less.next;
    }
}