class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i < n ; i++){
            if(grid[i][0] == 0){   
                for(int j = 0 ; j < m;j++){
                    grid[i][j]^=1;
                }
            }
        }
        
                // System.out.println(Arrays.deepToString(grid));

        for(int j = 0  ; j < m ; j++){
            int countz = 0;
            for(int i = 0 ;i <n;i++){
                if(grid[i][j] == 0)countz++;
            }
            if(countz > n/2){
                for(int i = 0 ; i < n;i++){
                    grid[i][j] ^=1;
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(grid));
        int sum = 0;
        
        for(int i = 0 ; i < n;i++){
            int temp = 0 ;
            for(int j = 0 ; j < m;j++){
                
                if(grid[i][j]==1){
                    
                    temp += (1<< (m-j-1));
                    
                }
                
            }
            sum+=temp;
            
        }
        
        return sum;
        
        
    }
}