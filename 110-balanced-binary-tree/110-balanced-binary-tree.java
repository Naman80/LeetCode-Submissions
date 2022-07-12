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
    public boolean isBalanced(TreeNode root) {
        Pair p = solve(root);
        
        return p.bal;
        
        
    }
    
    Pair solve(TreeNode root){
        
        if(root == null)return new Pair(true,0);
        
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        
        if(!left.bal || !right.bal)return new Pair(false,0);
        
        if(Math.abs(left.height - right.height) > 1) return new Pair(false,0);
        
        
        return new Pair(true , Math.max(left.height , right.height) +1);
        
        
    }
    
    
}

class Pair{
    
    boolean bal;
    int height;
    
    Pair(boolean bal,int h){
        this.bal= bal;
        this.height = h;
    }
}