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
    public int kthSmallest(TreeNode root, int k) {
        
        
        int[] count = new int[1];
        count[0] = k;
        solve(root,count);
        return ans;
    }
    
    
    void solve(TreeNode root , int[] k){
        if(root==null){
            return ;
        }
        
        solve(root.left , k);
        k[0]--;
        if(k[0]==0)ans = root.val;
        solve(root.right , k);
        
    }
}