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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(q.size() >0){
            
            int size = q.size();
            int temp = size;
            double sum = 0;
            while(size-- > 0){
                TreeNode out = q.poll();
                sum+=out.val;
                
                if(out.left  != null)q.add(out.left);
                if(out.right != null)q.add(out.right);
            }
            
            ans.add(sum/temp);
            
            
        }
        return ans;
        
    }
}