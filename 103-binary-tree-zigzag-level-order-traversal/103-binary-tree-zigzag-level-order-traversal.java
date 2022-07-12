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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root==null)return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        int count = 0;
        
        q.add(root);
        
        
        while(q.size()!=0){
            
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ;i < size ; i++){
                TreeNode out = q.poll();
                if(count%2==0){
                    temp.add(out.val);
                }else{
                    temp.add(0,out.val);
                }
                
            if(out.left!=null)q.add(out.left);
            if(out.right!=null)q.add(out.right);
            }
            count++;
            ans.add(new ArrayList<>(temp));
            
        }
        
        return ans;
        
        
        
        
        
//         List<List<Integer>> ans = new ArrayList<>();
//         if(root==null) return ans;
//         Queue<TreeNode> q  = new LinkedList<>();
        
//         q.add(root);
//         boolean flag = true;
//         while(q.size()!=0){
//             List<Integer> temp = new ArrayList<>();
//             int size = q.size();
          
//             while(size-- > 0){
                
//                   TreeNode out = q.poll();
//                 if(out.left!=null) q.add(out.left);
//                 if(out.right!=null) q.add(out.right);
                
//                 if(flag) temp.add(out.val);
//                 else temp.add(0,out.val);
                
//             }
            
//             ans.add(temp);
//             flag = !flag;
            
//         }
//         return ans;
        
        
        
        
        
    }
}