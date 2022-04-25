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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;       
       ListNode dummy  = new ListNode(-1);
       ListNode temp = head;
       int len = 0;
       ListNode curr = dummy;
       while(temp!=null){
           len++;
           temp = temp.next;
       }
       k = k%len;
       temp = head;       
       for(int i  = 1;i<=len-k;i++){
           if(i==len-k){
               dummy.next = temp.next;
               temp.next = null;
           }else{
               temp = temp.next;
           }  
       }      
       while(curr.next!=null){
           curr = curr.next;
       }
       curr.next = head;    
       return dummy.next;
    }
}