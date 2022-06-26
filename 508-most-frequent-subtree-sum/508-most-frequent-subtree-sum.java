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
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> hm = new LinkedHashMap<>();
        int totSum = solve(root, hm);
        int max  = Integer.MIN_VALUE;
        int count = 0;
        for(Integer x : hm.keySet()){
            if(hm.get(x) > max){
                max = hm.get(x);
                count=1;
            }else if(hm.get(x)==max)count++;
        }
        int[] ans = new int[count];
        int i = 0;
        for(Integer x : hm.keySet()){
            if(hm.get(x)==max){
                ans[i++] = x;
            }
        }
        return ans;   
    }
    int solve(TreeNode root , HashMap<Integer,Integer> hm){
        if(root==null)return 0 ;
        int left = solve(root.left,hm);
        int right = solve(root.right,hm);
        int temp = left + right + root.val;
        hm.putIfAbsent(temp,0);
        hm.put(temp,hm.get(temp)+1);
        return temp;
    }
    
}