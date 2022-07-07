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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode();
        
        ListNode temp = dummy;
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        
        int carry = 0;
        
        while(temp1!=null || temp2 != null){
            
            int sum = 0;
            if(temp1 != null)sum+=temp1.val;
            if(temp2 != null)sum+=temp2.val;
            sum+=carry;
            int length = (int) (Math.log10(sum) + 1);
            if(length == 2){
                int st = sum%10;
                carry = sum/10;
                sum = st;
            }
            if(length==1)carry =0;
            ListNode add = new ListNode(sum);
            temp.next = add;
            temp = temp.next;
            if(temp1 != null)temp1 = temp1.next;
            if(temp2 != null)temp2 = temp2.next;
        }
        if(carry!=0){
            ListNode add = new ListNode(carry);
            temp.next = add;
            temp = temp.next;
        }
        return dummy.next;
    
        
    }
}