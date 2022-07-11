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
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root==null)return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        int vislevel = 0;
        q.add(new Pair(root,1));
        
        while(q.size()!=0){
            
            Pair out = q.poll();
            TreeNode node = out.node;
            int lev = out.level;
            
            if(lev > vislevel){
                ans.add(node.val);
                vislevel++;
            }
            if(node.right != null)q.add(new Pair(node.right,lev+1));
           if(node.left != null)q.add(new Pair(node.left , lev+1));
            
        
            
        }
        
        return ans;
    }
}

class Pair{
    TreeNode node;
    int level;
    
    Pair(TreeNode node , int lev){
        this.node = node;
        this.level = lev;
    }
}