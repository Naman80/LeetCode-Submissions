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
class Solution {
    public int goodNodes(TreeNode root) {
        int[] s = new int[1];
        solve(root,Integer.MIN_VALUE,s);
        return s[0];
    }
    
    void solve(TreeNode root,int prev,int[] store){
        if(root==null)return ;
        if(root.val>=prev)store[0]++;
        if(root.left!=null){
        solve(root.left , Math.max(root.val,prev),store); 
        }
         if(root.right!=null){
           solve(root.right , Math.max(root.val,prev),store);
        }
    }
}