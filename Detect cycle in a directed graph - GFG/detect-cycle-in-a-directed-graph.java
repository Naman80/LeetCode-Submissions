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
        // boolean[] visit = new boolean[V];
        
        // boolean[] rec = new boolean[V];
        
        // for(int i = 0 ; i < V;i++){
            
        //     if(!visit[i]){
        //         if(dfs( i , adj,visit,rec))return true;
        //     }
        // }
        // return false;
         int[] indegree = new int[V];
        
        //calculate in-degree
        for(int i = 0 ;i <V;i++){
            for(int x:adj.get(i)){
                indegree[x]++;
            }
        }
        
        ArrayList<Integer> al = new ArrayList<>();
      return  bfs(V,adj,indegree,al);
        
    }
    
    // boolean dfs(int v, ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] rec){
    //     vis[v] = true;
    //     rec[v] = true;
    //     for(int x : adj.get(v)){
    //         if(!vis[x]){
    //             if(dfs(x,adj,vis,rec))return true;
    //         }else if(rec[x]) return true;
    //     }
    //     rec[v] = false;
    //     return false;
    // }
    
    static boolean bfs(int V, ArrayList<ArrayList<Integer>> adj,int[] indeg,ArrayList<Integer>al){
        
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<V;i++){
            if(indeg[i] == 0 ){
                q.add(i);
            }
        }
        int count = 0;
        while(q.size()!=0){
            
            int out = q.poll();
            al.add(out);
            
            for(int x : adj.get(out)){
                if(--indeg[x]==0){
                    q.add(x);
                }
            }
            count++;
            
        }
        
        return count!=V;
        
    }
    
}