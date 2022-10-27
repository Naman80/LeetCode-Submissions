class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        return solve(start , arr,vis);
    }
    
    
    public boolean solve(int start , int[] arr,boolean[] vis){
        
        if(start <0 || start>= arr.length)return false;
        if(arr[start]==0)return true;
        if(vis[start])return false;
        vis[start] = true;
    
        
        return solve(start + arr[start] , arr , vis) || solve(start - arr[start] ,arr,vis);
        
      
        
        
    }
}