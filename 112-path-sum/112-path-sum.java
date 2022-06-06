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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return solve(root,targetSum,0);
        
    }
    
    boolean solve(TreeNode temp , int tar , int sum){
        
        if(sum+temp.val == tar && temp.left==null && temp.right == null)return true;
        
        boolean left = false;
        boolean right = false;
        
        if(temp.left!=null) left = solve(temp.left,tar,sum+temp.val);
        if(temp.right != null) right = solve(temp.right,tar,sum+temp.val);
        
        return left || right;
    }
}