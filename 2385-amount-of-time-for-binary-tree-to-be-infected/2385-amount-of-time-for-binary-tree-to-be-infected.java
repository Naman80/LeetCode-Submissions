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

// step1 - make hashmap store all parents
// step2 - find start node 
// step3 - do bfs from start node while maintaining visited.
class Solution {
    
    HashMap<TreeNode , TreeNode> parent = new HashMap<>();
    TreeNode ini = null;
    int value = 0;
    public int amountOfTime(TreeNode root, int start) {
        value = start;
        dfs(root , null);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> vis = new HashSet<>();
        q.add(ini);
        vis.add(ini);
        int ans = 0;
        while(q.size()!=0){
            
            int size = q.size();
            ans++;
            for(int i = 0 ; i < size ; i++){
                
                TreeNode out = q.poll();
                
                if(out.left!=null && !vis.contains(out.left)){
                    q.add(out.left);
                    vis.add(out.left);
                }
                
                if(out.right!=null && !vis.contains(out.right)){
                    q.add(out.right);
                    vis.add(out.right);
                }
                
                if(parent.get(out)!=null && !vis.contains(parent.get(out))){
                    q.add(parent.get(out));
                    vis.add(parent.get(out));
                }
                
            }
            
        }
        
        return ans-1;
        
    }
    
    
    public void dfs(TreeNode node , TreeNode par){
        parent.put(node , par);
        if(node.val == value)ini = node;
        if(node.left!=null)dfs(node.left,node);
        if(node.right!=null)dfs(node.right,node);
    }
    
}