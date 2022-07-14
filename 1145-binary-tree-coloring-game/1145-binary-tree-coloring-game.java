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

// [1, 2, 4, 8, 8, 8, 4, 9, 9, 9, 4, 2, 5, 10, 10, 10, 5, 11, 11, 11, 5, 2, 1, 3, 6, 6, 6, 3, 7, 7, 7, 3, 1]

class Solution {
    
    ArrayList<Integer> EularTour = new ArrayList<>();
    int totNodes = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        eularTour(root);
        int size = EularTour.size();
        int start = 0 ; int end = 0 ; 
        int i = 0 ;
        int mid =0;
        for(int  k = 1 ; k < size-1;k++){
            if(EularTour.get(k)==x){
                mid = k;
                break;
            }
        }
        int midx = -1;
        for( ; i < size ; i++){
            
            if(EularTour.get(i)==x){
                
                start = i;
                break;
            }
        }
        i++;
        while(i<size){
            if(EularTour.get(i)==x){
                if(midx==-1){
                    midx=i;
                }
                end=i;
            }
            i++;
        }
        
        ///// Nodes below node x
        int xleft = (midx-start - 1)/3 ;
        int xright = (end - midx - 1)/3 ;
        int belowx = (end - start - 2)/3 + 1; // belowx + x
        int leftNode = totNodes - belowx;
        // System.out.println(EularTour);
         // System.out.println( start + " " + midx +" "+end+ " " + xleft + " " + xright);
        // System.out.println(leftNode + " " + belowx + " " + totNodes);
        if(leftNode == 0){
            int leftdown = (mid-1)/3;
            int rightdown = (size - mid -2)/3;
            if(Math.abs(leftdown - rightdown) >= 2)return true;
            else return false;
        }else if(leftNode > belowx){
            return true;
        }else if((xleft > leftNode + 1 + xright ) || (xright > leftNode + 1 +xleft)){
            return true;
        } 
       
        return false;
        
        
        
        
//         System.out.println(EularTour.get(start) + " " +start + " " + EularTour.get(end) + " "+end);
        
//         System.out.println(EularTour);
//         return true;
        
        
        
        
        
    }
    
    void eularTour(TreeNode root){
        if(root==null)return ;
        totNodes++;
        EularTour.add(root.val);
        eularTour(root.left);
        EularTour.add(root.val);
        eularTour(root.right);
        EularTour.add(root.val);
    }
    
}