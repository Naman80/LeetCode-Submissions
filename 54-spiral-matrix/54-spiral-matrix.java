class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] vis = new boolean[m][n];
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i < m;i++){
            for(int j = 0 ; j < n;j++){
                if(!vis[i][j]){
                    dfs(i,j,matrix,vis,ans);
                }
            }
        }
        // dfs(0,0,matrix,vis,ans);
        return ans;
        
        
        
    }
    
    void dfs(int r , int c , int[][] matrix ,   boolean[][] vis , List<Integer> ans ){
        int m = matrix.length;
        int n = matrix[0].length;
        vis[r][c] = true;
        ans.add(matrix[r][c]);
        while(c + 1 < n && !vis[r][c+1] ){
            vis[r][c+1] = true;
            ans.add(matrix[r][c+1]);
            c++;
            // dfs(r,c+1,matrix,vis,ans);   
        }
        
        while( r + 1 < m && !vis[r+1][c]){
            vis[r+1][c] = true;
            ans.add(matrix[r+1][c]);
            r++;
            // dfs(r+1,c,matrix,vis,ans);
        }
        while( c -1 >=0  && !vis[r][c-1]){
            vis[r][c-1] = true;
            ans.add(matrix[r][c-1]);
            c--;
            // dfs(r,c-1,matrix,vis,ans);
        }
         while(r - 1 >=0  && !vis[r-1][c] ){
            vis[r-1][c] = true;
            ans.add(matrix[r-1][c]);
            r--;
             // dfs(r-1,c,matrix,vis,ans);
        }
    }
    
    
    
}