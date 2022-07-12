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
    public int pathSum(TreeNode root, int tar) {
        // https://www.youtube.com/watch?v=uZzvivFkgtM&ab_channel=CodeAndCoffee
      //  Two Approachs - 1. O(n^2)  2. O(n) 
      // O(n) appraoch uses hashmap of running sum
        // prefix tree method
        
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return solve(root,0,tar,map);
        
            
    }
    
    
    int solve (TreeNode root ,int rsum, int tar , HashMap<Integer,Integer> map){
        
        if(root==null)return 0;
        
        rsum += root.val;
        int count = map.getOrDefault(rsum - tar , 0 );
        map.put(rsum , map.getOrDefault(rsum , 0 )+1);
        
        count += solve(root.left,rsum,tar,map)+solve(root.right,rsum,tar,map);
        
        if(map.get(rsum)==1){
            map.remove(rsum);
        }else map.put(rsum,map.get(rsum)-1);
        
        return count;
        
    }
}