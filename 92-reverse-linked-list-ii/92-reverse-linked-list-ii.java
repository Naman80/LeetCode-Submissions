// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode reverseBetween(ListNode head, int left, int right) {
        
//         if(left == right || head == null || head.next == null)return head;
        
        
//         ListNode dummy  = new ListNode(-1);
//         dummy.next= head;
//         ListNode prev1 = dummy;
// //         left--;
// //         right--;
        
//         while(--left > 0){
//             prev1 = prev1.next;
//         }
        
//         ListNode first = prev1.next;
        
//         ListNode prev2 = dummy;
        
//         while(--right > 0){
//             prev2 = prev2.next;
//         }
        
//         ListNode second = prev2.next;
        
        
//         prev1.next = first.next; // deleting both nodes
//         prev2.next = second.next;
        
        
//         second.next = prev1.next; //adding nodes again
//         prev1.next = second;
        
//         first.next = prev2.next;
//         prev2.next = first;
        
        
//         return dummy.next;
        
        
//     }
// }


class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}