// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    
    //THIS QUESTION IS MORE OF RECURSION AND BACKTRACKING TYPE QUESTION
    
    // IN THIS QUES WE ARE TRYING OUT ALL THE POSSIBLE COLORS TO EVERY NODE 
    // AND IF AT END WE REACH THE LAST NODE THEN RETURN TRUE
    
    
    
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<graph.length;i++){
            for(int j = 0 ; j < graph[0].length ; j++){
                if(graph[i][j]){
                    adj.get(i).add(j);
                }
            }
        }
        int[] color = new int[n];
        return solve(0,n,adj,m,color);
    }
    
    // COLORING NODE WISE LIKE 0 -> 1 -> 2 -> 3 -> 4 ...
    //WE ARE NOT COLORING CONNECTION WISE
    
    boolean solve(int v ,int n,  ArrayList<ArrayList<Integer>> adj , int m ,int[] color){
        if( v == n)return true;
        for(int i = 1 ; i <= m ;i++){ // CHECKING ALL THE COLORS 
            if(isSafe(v,color,i,adj)){ // IF COLOR IS SAFE OR NOT
                color[v] = i;  
                if(solve(v+1,n,adj,m,color))return true;
                color[v] = 0;  // BACKTRACKING STEP IMPORTANT
            }
        }
        return false;
    }
    
    // CHECKING IF ANY ADJACENT NODE IS COLOURED WITH THE SAME COLOR OR NOT
    
    boolean isSafe(int v, int[] color , int col , ArrayList<ArrayList<Integer>> adj){
        for(int x : adj.get(v)){
            if(color[x] == col)return false; // IF SAME COLOR ALREADY THEN THIS COLOR IS NOT ALLOWED
        }
        return true; //NON OF THE ADJACENT NODE HAVE THIS COLOR
    }
    
    
    
}