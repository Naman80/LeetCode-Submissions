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
    HashMap<Integer,Integer> map;
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i = 0 ; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        int n = postorder.length;
        postIndex = n-1;    
        
        return convert(postorder , 0 , n-1);
        
        
    }
    
    TreeNode convert(int[] postorder , int left ,int right){
        
        if(left > right)return null;
        
        int rootval = postorder[postIndex--];
        TreeNode root = new TreeNode(rootval);
        
        
        root.right = convert( postorder , map.get(rootval) + 1 , right );
        root.left = convert(  postorder , left , map.get(rootval)-1 );
        
        return root;
        
        
    }
}