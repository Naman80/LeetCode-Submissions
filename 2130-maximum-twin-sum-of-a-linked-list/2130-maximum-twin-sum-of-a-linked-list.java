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
    public int pairSum(ListNode head) {
        
        ListNode mid = midFind(head);
        ListNode rev = reverse(mid.next);
        mid.next = rev;
        mid = mid.next;
        int max = Integer.MIN_VALUE;
        ListNode temp = head;
        while(mid!=null){
            int sum = temp.val + mid.val;
            max = Math.max(max,sum);
            temp = temp.next;
            mid = mid.next;
        }
        
        return max;
        
        
    }
    
    ListNode reverse(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
        
    }
    
    ListNode midFind(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!=null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
        
    }
    
    
}