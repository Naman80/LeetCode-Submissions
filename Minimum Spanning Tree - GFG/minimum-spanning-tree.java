// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    static int[] parent;
    static int[] rank;
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        parent = new int[V];
        rank = new int[V];
        for(int i =0;i<V;i++){
            parent[i] = i;
        }
        ArrayList<ArrayList<Integer>> newadj = new ArrayList<>();
        for(int i = 0;i<adj.size();i++){
            for(ArrayList<Integer> y : adj.get(i)){
                y.add(0,i);
                newadj.add(y);
            }
        }
        Collections.sort(newadj , (a,b) -> a.get(2) - b.get(2));
        int ans=0;
        for(ArrayList<Integer> x : newadj){
            
            if(findpar(x.get(0)) != findpar(x.get(1))){
                ans += x.get(2);
                union(x.get(0) , x.get(1));
            }
            
        }
        return ans;
    }
    static int findpar(int x){
        if(parent[x]==x)return x;
        
        return parent[x] = findpar(parent[x]);
    }
    static void union(int u , int v){
        u = findpar(u);
        v = findpar(v);
        
        if(rank[u] < rank[v]){
            parent[u] = v;
        }else if(rank[v] < rank[u]){
            parent[v] = u;
        }else{
            parent[v] = u;
            rank[u]++;
        }
        
    }
}
