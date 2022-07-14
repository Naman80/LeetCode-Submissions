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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        solve(root,"");
        return sum;
    }
    
    void solve(TreeNode root,String temp){
        if(root.left == null && root.right == null){
            // temp*=10;
            temp+=root.val;
            // System.out.println(temp);
            sum+=deciToBin(temp);
            return;
        }
        
        // temp*=10;
        temp+=root.val;
        if(root.left!=null)solve(root.left , temp);
        if(root.right!=null)solve(root.right,temp);
        
        
    }
    
     int deciToBin(String x){
         int temp = 0;
            int n = x.length();
         
         int i = n-1;
         while(i>=0){
             if(x.charAt(i)=='1'){
                 temp+= (1<<(n-1-i));
             }
             i--;
         }
         
         // System.out.println(temp);
         return temp;
         
         
     }
    
    
}