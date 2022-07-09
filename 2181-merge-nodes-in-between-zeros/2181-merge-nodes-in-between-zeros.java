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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode dummy = new ListNode();
        ListNode d1 = dummy;
        ListNode temp = head.next;
        int sum = 0;
        while(temp != null){
            
            while(temp.val!=0){
                sum+=temp.val;  
                temp = temp.next;
            }
            ListNode newnode = new ListNode(sum);
            d1.next = newnode;
            d1 = d1.next;
            temp= temp.next;
            sum = 0;
        }
        
        return dummy.next;
        
    }
}