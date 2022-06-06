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
    public List<List<Integer>> pathSum(TreeNode root, int tar) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        solve(root,tar,0,ans,new ArrayList<Integer>());
        
        return ans;
    }
    
    public void solve(TreeNode temp , int tar , int sum , List<List<Integer>> ans , List<Integer> al){
        
        if(sum+temp.val == tar && temp.left == null && temp.right == null){
            
            al.add(temp.val);
            ans.add(new ArrayList<>(al));
            al.remove(al.size()-1);
            return;
            
        }
        
        if(temp.left != null){
            al.add(temp.val);
            solve(temp.left ,tar,sum+temp.val,ans,al);
             al.remove(al.size()-1);
            
        }
        
        if(temp.right != null){
            al.add(temp.val);
            solve(temp.right , tar , sum+temp.val , ans , al);
             al.remove(al.size()-1);
        }
        
    }
    
    
}