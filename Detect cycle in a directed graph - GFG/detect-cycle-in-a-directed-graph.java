// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       
    //   boolean[] vis = new boolean[V];
    // //   boolean[] rec = new boolean[V];
    //   for(int i = 0 ; i < V;i++){
           
    //     //   if(!vis[i]){
    //     //       if(dfs(i,adj,vis,rec)) return true;
    //     //   }
           
    //   }
       
       int[] ind = new int[V];
       for(int i = 0;i<V;i++){
           for(int x :adj.get(i)){
               ind[x]++;
           }
       }
       
       ArrayList<Integer> al = new ArrayList<>();
       
       Queue<Integer> q = new LinkedList<>();
       
       for(int i = 0;i<V;i++){
           if(ind[i]==0)q.add(i);
       }
       
       int count = 0;
       
       while(!q.isEmpty()){
           
           int node = q.poll();
           al.add(node);
           
           for(int x : adj.get(node)){
               if(--ind[x] == 0)q.add(x);
           }
           count++;
       }
       if(count != V) return true;
       else return false;
    }
    
    // i can also use topological sort to find cycle in direct acyclic graph
    
    // boolean dfs(int v , ArrayList<ArrayList<Integer>> adj , boolean[] vis ,boolean[] recS){
        
    //     vis[v] = true;
        
    //     recS[v] = true;
        
    //     for(int x : adj.get(v)){
            
    //         if(!vis[x]){
    //             if(dfs(x,adj,vis,recS))return true;
    //         }else if(recS[x]) return true;
            
    //     }
        
    //     recS[v] = false;
        
    //     return false;
        
        
    // }
    
    boolean bfs (int v ,ArrayList<ArrayList<Integer>> adj , boolean[] vis ,boolean[] recS){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        vis[v] = true;
        recS[v] = true;
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            
            for(int x : adj.get(node)){
                
                if(!vis[x]){
                    vis[x] = true;
                    recS[x] = true;
                    q.add(x);
                }else if(recS[x]) return true;
                
            }
            
        }
        
        return false;
    }
}