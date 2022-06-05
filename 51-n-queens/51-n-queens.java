class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        String[][] board = new String[n][n];
        for (String[] x :  board){
            Arrays.fill(x,".");
        }
        solve(0,n,board,ans);
        return ans;
    }
    
     static public void solve(int row ,int n, String[][] board , List<List<String>> ans ){

        if (row>=n){
            List<String> ol = new ArrayList<>();
            for (String[] x : board){
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < x.length; i++) {
                    s.append(x[i]);
                }
                ol.add(String.valueOf(s));
            }
            ans.add(ol);
            return;
        }

        for(int col = 0 ; col < n;col++){
            if(isSafePlace(row,col,board)){
                board[row][col] = "Q";
                solve(row+1,n,board,ans);
                board[row][col] = ".";
            }
        }


    }

    private static boolean isSafePlace(int row, int col, String[][] board) {

        int dr = row-1;
        int dc  = col;
        while(dr >=0 && dc >=0){
            if (Objects.equals(board[dr][dc], "Q")) return false;
            dr--;
        }

        dr = row-1;
        dc  = col-1;
        while(dr >=0 && dc >=0){
            if (Objects.equals(board[dr][dc], "Q")) return false;
            dr--;
            dc--;
        }

        dr = row-1;
        dc  = col+1;
        while(dr >=0 && dc< board.length){
            if (Objects.equals(board[dr][dc], "Q")) return false;
            dr--;
            dc++;
        }

        return true;

    }

}