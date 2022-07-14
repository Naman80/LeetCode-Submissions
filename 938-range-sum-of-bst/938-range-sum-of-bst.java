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
   int sum = 0;
    int left;
    int right;
    public int rangeSumBST(TreeNode root, int low, int high) {
        left = low;
        right = high;
        solve(root);
        return sum;
        
        
    }
    
    void solve(TreeNode root){
        
        if(root==null)return;
        
        if(root.val >= left && root.val <= right){
            sum+=root.val;
        }
        solve(root.left);
        solve(root.right);
        
    }
    
    
}