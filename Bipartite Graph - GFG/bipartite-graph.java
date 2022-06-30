// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{  int[] colour;
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        colour = new int[V];
        for(int i = 0 ; i < V;i++){
            colour[i] = -1;
        }
        for(int i = 0;i<V;i++){
            if(colour[i] == -1){
                if(!bfs(i,adj))return false;
            }
        }
        return true;
    }
    // boolean dfs(int v , ArrayList<ArrayList<Integer>>adj){
    //     if(colour[v] == -1) colour[v] = 1;
    //     for(int x : adj.get(v)){
    //         if(colour[x]==-1){
    //             colour[x] = 1 - colour[v];
    //             if(!dfs(x,adj))return false;
    //         }else{
    //             if(colour[v] == colour[x])return false;
    //         }
    //     }
    //     return true;
    // }
    
    boolean bfs(int v , ArrayList<ArrayList<Integer>> adj){
        
        if(colour[v] == -1)colour[v] = 1;
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(v);
        
        while(q.size()!=0){
            int out = q.poll();
            for(int x : adj.get(out)){
                if(colour[x]==-1){
                    colour[x] = 1 - colour[out];
                    q.add(x);
                }else if(colour[x]==colour[out])return false;
            }
        }
        
        
        return true;
        
        
    }
}