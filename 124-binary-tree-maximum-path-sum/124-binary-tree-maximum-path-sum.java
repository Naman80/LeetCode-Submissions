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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int temp  = solve(root);
        return Math.max(ans,temp);   
    }
    int solve(TreeNode root){
        if(root==null)return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        int temp = Math.max(Math.max(left+right+root.val , root.val) , Math.max(left,right) + root.val);
        ans = Math.max(temp,ans);
        return Math.max(Math.max(left,right) + root.val,root.val);        
    }
}