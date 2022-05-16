// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        
        ArrayList<String> store = new ArrayList<>();
        solve(0,0,m,"", new boolean[n][n],store);
        
        return store;
        
    }
    
    static void solve(int r , int c , int[][] maze , String ans , boolean[][] check,ArrayList<String> al){
        if(maze[r][c]==0)return;
        if (r== maze.length-1 && c== maze.length-1){
                al.add(ans);
                return;
            }

        check[r][c] = true;
        if(r-1 >=0 && !check[r-1][c]){
            solve(r-1 , c , maze , ans +"U",check,al );

        }
        if(r+1 < maze.length && !check[r+1][c] ){

            solve(r+1 , c , maze , ans +"D",check,al );

        }
        if(c-1 >=0 && !check[r][c-1] ){

            solve(r , c-1 , maze , ans +"L",check ,al);

        }
        if(c+1 < maze.length && !check[r][c+1]){

            solve(r , c+1 , maze , ans +"R",check ,al);

        }

        check[r][c] = false;

    }

    
    
    
    
}