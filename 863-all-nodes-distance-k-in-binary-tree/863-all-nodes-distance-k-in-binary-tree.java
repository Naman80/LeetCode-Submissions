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
    
    //this is submitted solution using root to node path and kdown function
    
    // public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    //     ArrayList<TreeNode> al = new ArrayList<>();
    //     rtnp(root,target,al);
    //     List<Integer> ans = new ArrayList<>();
    //     kdown(target,target,k,ans);
    //     for(int i = 1 ; i < al.size();i++){
    //         kdown(al.get(i),al.get(i-1),k-i,ans);   
    //     }
    //     return ans;
    // } 
    // void rtnp(TreeNode root, TreeNode tar,ArrayList<TreeNode> al){   
    //     if(root==null)return;
    //     if(root == tar){
    //         al.add(tar);
    //         return;
    //     }
    //     rtnp(root.left , tar , al);
    //     if(al.size()!=0){
    //         al.add(root);
    //         return ;
    //     }
    //     rtnp(root.right , tar,al);
    //     if(al.size()!=0){
    //         al.add(root);
    //         return;
    //     }
    // }
    // void kdown(TreeNode root,TreeNode tar,int k,  List<Integer> ans){
    //     if(root==null)return;
    //     if(k==0){
    //         ans.add(root.val);
    //         return;
    //     }
    //     if(root.left!= tar)kdown(root.left,tar,k-1,ans);
    //     if(root.right!= tar)kdown(root.right,tar,k-1,ans);
    // }

    
    // now method 2 by storing parent of all the nodes;
    
    
    HashMap<TreeNode,TreeNode>parent = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        dfs(root,null);
        
        Queue<Pair> q = new LinkedList<>();
        
        
        boolean[] vis = new boolean[501];
        q.add(new Pair(target,0));
        vis[target.val] = true;
        List<Integer> ans = new ArrayList<>();
        while(q.size() != 0){
            
            Pair out = q.remove();
            TreeNode ot = out.node;
            int dis = out.dis;
            
            if(dis==k){
                ans.add(ot.val);
                continue;
            }
            
            if(ot.left != null && !vis[ot.left.val]){
                q.add(new Pair(ot.left,dis+1));
                vis[ot.left.val] = true;
            }
             if(ot.right != null && !vis[ot.right.val]){
                q.add(new Pair(ot.right,dis+1));
                vis[ot.right.val] = true;
            }
            if(parent.get(ot)!=null && !vis[parent.get(ot).val]){
                q.add(new Pair(parent.get(ot),dis+1));
                vis[parent.get(ot).val] = true;
            }   
        }
        
        return ans;
    }
    // dfs for parent storage
    void dfs(TreeNode root, TreeNode par){
        if(root==null)return;
        parent.put(root,par);
        dfs(root.left,root);
        dfs(root.right , root);   
    }   
}
class Pair{
    TreeNode node;
    int dis ;
    Pair(TreeNode node,int dis){
        this.node = node;
        this.dis = dis;
    }
}