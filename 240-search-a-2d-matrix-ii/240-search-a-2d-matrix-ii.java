class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int row = n-1;
        int col = 0;
        
        while(row >=0 && col < m){
            int num = matrix[row][col];
            if(num==target)return true;
            if(num > target){
                row--;
            }else{
                col++;       
            }
        }
        return false;
        
    }
}