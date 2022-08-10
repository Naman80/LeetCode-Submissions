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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        int i = 0 , j = n-1;
        
        return solve(i , j , nums);
        
    }
    
    
    public TreeNode solve(int i , int j , int[] nums){
        
        if(i > j)return null;
        
        int mid = (i+j)/2;
        
        TreeNode temp = new TreeNode(nums[mid]);
        
        temp.left  = solve(i , mid - 1 , nums);
        temp.right = solve(mid + 1 , j , nums);
        
        return temp;
        
    }
}