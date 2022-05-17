/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    static TreeNode ans = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
       solve(cloned,target);
        return ans;
    }
    
    
    void solve(TreeNode clone , TreeNode target){
        if(clone == null)return;
        if(clone.val == target.val){
            ans = clone;
            return;
        }
        
        solve(clone.left,target);
        solve(clone.right,target);
        
    }
    
    
}