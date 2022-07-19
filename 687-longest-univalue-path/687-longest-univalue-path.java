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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        
        int temp  = solve(root,null);
        
        return ans;
        
    }
    
    int solve(TreeNode root , TreeNode par){
        if(root==null)return 0;
        
        int left = solve(root.left , root);
        int right = solve(root.right , root);
        ans = Math.max(left + right , ans);
        if(par !=null && root.val == par.val)return Math.max(left, right)+1;
        else return 0;
        
    
        
        
        
    }
}