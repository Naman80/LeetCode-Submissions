// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        int n = adj.size();
        
        for(int i = 0 ;i < n; i++){
            adj1.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i <n;i++){
            for(int j = 0;j<n;j++){
                if(i!=j && adj.get(i).get(j) == 1){
                    adj1.get(i).add(j);
                }
            }
        }
        
        boolean[] vis  = new boolean[V];
        int com = 0;
        for(int i = 0 ; i<V;i++){
            if(!vis[i]){
                com++;
                dfs(i,adj1,vis);
            }
        }
        
        return com;
        
    }
    
    
   static void dfs(int v ,  ArrayList<ArrayList<Integer>> adj ,boolean[] vis){
        vis[v] = true;
        
        for(int x : adj.get(v)){
            if(!vis[x]){
                dfs(x,adj,vis);
            }
        }
    }
};