class NumMatrix {
    int[][] newmat;
    int[][] prefixsum;
    public NumMatrix(int[][] matrix) {
        newmat = matrix;
        int n = newmat.length;
        int m  = newmat[0].length;
        prefixsum = new int[n][m];
        for(int i = 0;i<n;i++){
            int sum = 0 ;
            for(int j = 0;j<m;j++){
                sum+=matrix[i][j];
                prefixsum[i][j] = sum;
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int n = newmat.length;
        int m  = newmat[0].length;
        int sum = 0;
        for(int i = row1;i<=row2;i++){
            
        if(col1-1>=0){
            sum+= (prefixsum[i][col2] - prefixsum[i][col1 - 1]);
        }else{
            sum+=prefixsum[i][col2];
        }         
            
        }
                   
                   return sum;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */