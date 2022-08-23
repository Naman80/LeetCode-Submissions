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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> al =  new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            al.add(temp.val);
            temp = temp.next;
        }
        int size = al.size();
        int i =0 ;
        int j = size-1;
        while(j > i){
            if(al.get(i)!=al.get(j))return false;
            i++;
            j--;
        }
        return true;
    }
}