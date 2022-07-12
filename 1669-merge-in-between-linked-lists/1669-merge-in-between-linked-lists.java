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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode temp = list1;
        ListNode prev = null;
        b = b-a;
        while(a-- > 0){
            prev= temp;
            temp = temp.next;
        }
        
        while(b-- > 0){
            temp = temp.next;
        }
        ListNode end = list2;
        while(end.next!=null){
            end = end.next;
        }
        prev.next = list2;
        end.next = temp.next;
        
        return list1;
        
    }
}