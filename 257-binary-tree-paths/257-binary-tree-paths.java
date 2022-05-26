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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> ans  = new ArrayList<>();
        
        solve(root,"",ans);return ans;
    }
    
    
    void solve(TreeNode root,String s,List<String> al){
        
        
        if(root.right==null && root.left==null){
            s = s + root.val;
            al.add(s);
            return;
        }
        
        
        if(root.left!=null)solve(root.left,s+root.val+"->",al);
        if(root.right!=null)solve(root.right,s+root.val+"->",al);
        
    }
}