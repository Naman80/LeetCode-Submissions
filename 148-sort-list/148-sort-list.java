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
    public ListNode sortList(ListNode head) {
    
        //base condition
        if(head == null || head.next == null) return head;
        // breaking LL into two -> many parts
        ListNode left  = head;
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        
        // sorting two parts of LL
        ListNode part1 = sortList(left);
       ListNode part2 = sortList(right);
        
        
        //merge two parts
        
        return merge(part1 , part2);
    }
    // findind middle of linked list
    
    ListNode findMid(ListNode temp){
        
        ListNode slow = temp;
        ListNode fast = temp.next;
        
        while(fast != null && fast.next!=null){
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
        
    }
    
    // merging two sorted linked list
    
    ListNode merge(ListNode p1 , ListNode p2){
        if(p1==null)return p2;
        if(p2==null) return p1;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(p1!=null && p2!=null){
            if(p1.val>p2.val){
                temp.next = p2;
                temp = p2;
                p2 = p2.next;
            }else{
                temp.next = p1;
                temp = p1;
                p1= p1.next;
            }
        }
        if(p1==null){
            temp.next = p2;
        }else if(p2 == null){
            temp.next = p1;
        }
        return dummy.next;
    }
}