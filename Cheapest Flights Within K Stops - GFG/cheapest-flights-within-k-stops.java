//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    int ans = Integer.MAX_VALUE;
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++)adj.add(new ArrayList<>());
        for(int[] x : flights){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(x[1]);
            temp.add(x[2]);
            adj.get(x[0]).add(temp);
        }
        boolean[] vis = new boolean[n];
        solve(src , 0 , k ,dst , 0 , adj, vis);
        if(ans == Integer.MAX_VALUE)return -1;
        return ans;
        
    }
    
    
    public void solve(int v ,int stop , int k , int dst ,int cost , ArrayList<ArrayList<ArrayList<Integer>>> adj  , boolean[] vis){
        vis[v] = true;
        if(stop > k+1){vis[v] = false;return;}
        if(v == dst){
            ans= Math.min(ans , cost);
            vis[v] = false;
            return;
        }
        ArrayList<ArrayList<Integer>> neighbours = adj.get(v);
        for(ArrayList<Integer> al : neighbours){
            if(!vis[al.get(0)]){
                solve(al.get(0) , stop+1,k,dst , cost + al.get(1) , adj,vis);
            }
        }
        
        vis[v] = false;
        
    }
}



