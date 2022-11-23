class Solution {
   public boolean isValidSudoku(char[][] b) {
//        boolean check = true;
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(b[i][j] != '.'){
                    if(!isSafe(b, b[i][j] - '0', i, j))return false;
                }
            }
        }
        return true;

    }

    static boolean isSafe(char[][] b,int n,int r,int c){
        // checking rows and columns
        for(int i = 0;i<9;i++){
            if(i!=c)
                if(b[r][i] == (char)(n + '0')){
                return false;
                }

            if(i!=r)
                if(b[i][c] == (char)(n + '0')){
                    return false;
                }
        }
        int R = (r/3) * 3;
        int C = (c/3) * 3;
        // checknig the box 
        for(int i = R;i<=R+2;i++){
            for(int j = C;j<=C+2;j++){
                if(j==c) continue;
                if(b[i][j] == (char)(n + '0')){
                    return false;
                }
            }
        }
        return true;
    }
    
}