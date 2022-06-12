class Solution {
    // https://youtu.be/STrSxM_-imM
    // int ans = Integer.MAX_VALUE;
    public int minPathCost(int[][] grid, int[][] move) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n;j++){
//                 System.out.print(grid[i][j] + " ");
//             }
//             System.out.println(i);
//         }
        
        for(int i =0;i<n;i++){
          dp[m-1][i] =  grid[m-1][i] ;
            // System.out.print(grid[m-1][i] + " ");
        }
        
        for(int i= m-2;i>=0;i--){
            for(int j = 0;j<n;j++){
                int val = grid[i][j];
                int min = Integer.MAX_VALUE;
                for(int k = 0 ;k<n;k++){
                    min = Math.min(min,dp[i+1][k] + move[val][k]);
                }
                dp[i][j] = val + min;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0 ;i<n;i++){
            ans = Math.min(ans,dp[0][i]);
        }
        
        return ans;
        // ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        // for(int i = 0 ;i<= (m*n)-1;i++){
        //     adj.add(new ArrayList<ArrayList<Integer>>());
        // }
        // for(int i = 0 ; i < m-1 ;i++){
        //     for(int j = 0 ; j < n ; j++){
        //         int val = grid[i][j];
        //         for(int k = 0; k < n ; k++){
        //             ArrayList<Integer> al = new ArrayList<>();
        //             al.add(grid[i+1][k]);
        //             al.add(move[val][k]);
        //             adj.get(val).add(al);
        //         }
        //     }
        // }
        // for(int i = 0;i<n;i++){
        //     dfs(grid[0][i] , adj,0);
        // }
        // return ans; 
        
    }
//     public void dfs(int v , ArrayList<ArrayList<ArrayList<Integer>>> adj ,int sum){
//         sum+=v;  
//         if(adj.get(v).size()==0){
//             ans = Math.min(ans,sum);
//             return;
//         }
//         ArrayList<ArrayList<Integer>> x = adj.get(v);
//         for(ArrayList<Integer> y : x){
//             sum+=y.get(1);
//             dfs(y.get(0),adj,sum);
//             sum-=y.get(1);
//         }
//     }
}