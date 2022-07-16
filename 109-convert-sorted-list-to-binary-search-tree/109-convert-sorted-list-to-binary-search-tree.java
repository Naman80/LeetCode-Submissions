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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
public TreeNode sortedListToBST(ListNode head) {
    if(head==null)
        return null;
    ListNode slow = head;
    ListNode fast = head;
    ListNode temp=null;
    
    //find the mid node
    while(fast.next!=null && fast.next.next!=null){
        fast = fast.next.next;
        temp = slow;
        slow = slow.next;
    }
    
    if(temp!=null)
        temp.next = null; //break the link
    else
        head = null;
        
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);
    return root;
}
}
