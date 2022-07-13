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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(q.size()!=0){
            
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            
            while(size-- > 0){
                
            TreeNode out = q.poll();
            
            temp.add(out.val);
            
            if(out.left!=null)q.add(out.left);
            if(out.right!=null)q.add(out.right);
            
            }
            
            ans.add(temp);
        
        }
        
        return ans;
        
        
    }
}