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
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      
        ArrayList<TreeNode> al = new ArrayList<>();
        rtnp(root,target,al);
        List<Integer> ans = new ArrayList<>();
        kdown(target,target,k,ans);
        for(int i = 1 ; i < al.size();i++){
            
            kdown(al.get(i),al.get(i-1),k-i,ans);
            
        }
        
        return ans;
        
        
    } 
    void rtnp(TreeNode root, TreeNode tar,ArrayList<TreeNode> al){   
        if(root==null)return;
        if(root == tar){
            al.add(tar);
            return;
        }
        rtnp(root.left , tar , al);
        if(al.size()!=0){
            al.add(root);
            return ;
        }
        rtnp(root.right , tar,al);
        if(al.size()!=0){
            al.add(root);
            return;
        }
    }
    
    void kdown(TreeNode root,TreeNode tar,int k,  List<Integer> ans){
        if(root==null)return;
        if(k==0){
            ans.add(root.val);
            return;
        }
        if(root.left!= tar)kdown(root.left,tar,k-1,ans);
        if(root.right!= tar)kdown(root.right,tar,k-1,ans);
    }
    
    
}