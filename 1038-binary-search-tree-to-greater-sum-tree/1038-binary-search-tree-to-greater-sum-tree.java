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
    public TreeNode bstToGst(TreeNode root) {
        
        
        solve(root, new int[1]);
        return root;
        
        
    }
    
    
    public void solve(TreeNode root ,int[] sum){
        if(root==null)return ;
        solve(root.right,sum);
        root.val+=sum[0];
        sum[0]=root.val;
        solve(root.left, sum);
     
        
    }
}