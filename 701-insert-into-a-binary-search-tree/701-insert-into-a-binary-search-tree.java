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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        TreeNode temp = root;
        boolean check = false;
        while(temp!=null){
            if(temp.val > val){
                if(temp.left ==null){
                check =true;
                    break;
                }
                temp = temp.left;
            }else {
                if(temp.right == null)break;
                temp = temp.right;}
        }
        TreeNode newNode = new TreeNode(val);
        if(root==null)return newNode;
        if(check)temp.left = newNode;
        else temp.right = newNode;
        
        return root;
    }
}