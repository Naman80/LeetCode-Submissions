class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int idx = 0;
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[n*m];
        int i = 0;
        int j  = -1;
        
        int turn = 0;
        
       for(int k = 0 ; k < (n+m-1) ; k++){
           
           if(turn ==0){
                j++;
                while(i < n && j < m && i >=0 && j >=0){
                    ans[idx] = mat[i][j];
                    i--;
                    j++;
                    idx++;
                    
                }
               if(j==m){
                   j--;i++;
               }
                turn =1;
                
                
            }else{
                
                i++;
                 while(i < n && j < m && i >=0 && j >=0){
                    ans[idx] = mat[i][j];
                    i++;
                    j--;
                     idx++;
                }
               if(i==n){
                   i--;j++;
               }
                turn =0;
                
                
            }
           
           
       }
            
            return ans;
            
            
            
        
        
    }
}