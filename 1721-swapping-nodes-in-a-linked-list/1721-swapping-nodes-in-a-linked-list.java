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
    public ListNode swapNodes(ListNode head, int k) {
        
        
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        temp = head;
        ListNode sec = head;
        int countf = 1;
        int countb = 1;
        while(countf!=k){
            countf++;
            temp = temp.next;
        }
        int newk = len - k +1;
        while(countb!=newk){
            countb++;
            sec = sec.next;
        }
        int store = temp.val;
        temp.val = sec.val;
        sec.val = store;
        return head;
    }
}