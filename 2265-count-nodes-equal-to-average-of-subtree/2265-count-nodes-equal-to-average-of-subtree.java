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
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }
    
   
    public pair solve(TreeNode root){
        
        if(root==null){
            return (new pair(0,0));
        }
        pair leftp = solve(root.left);
        pair rightp = solve(root.right);
        
        int allsum  = leftp.sum + rightp.sum + root.val;
        
        int div = leftp.count + rightp.count+1;
        
        if(allsum/div == root.val)ans++;
        
        pair ret = new pair(allsum,div);
        
        return ret;
    }
}

class pair{
    
    int sum  = 0;
    int count = 0;
    
    pair(int s,int c){
        sum = s;
        count= c;
    }
    
}