//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] dis = new int[n+1];
        Arrays.fill(dis , Integer.MAX_VALUE);
        for(int i = 0 ; i <= n ; i ++){
            adj.add(new ArrayList<>());
        }
        for(int[] x : flights){
            adj.get(x[0]).add(new Pair(x[1] , x[2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dis[k] = 0;
        pq.add(new Pair(k , 0));
        while(pq.size()!=0){
            Pair out = pq.poll();
            for(Pair x : adj.get(out.node)){
                int node = x.node;
                int dist = x.dis;
                if(dis[node]> out.dis + dist){
                    dis[node] = out.dis+dist;
                    pq.add(new Pair(node , dis[node]));
                }
            }
            
        }
        dis[0] = 0;
        int max = Integer.MIN_VALUE;
        for(int x : dis)max = Math.max(max, x);
        
        if(max == Integer.MAX_VALUE)return -1;
        return max;
        
    }
}

 class Pair implements Comparable<Pair>{
        int node ;
        int dis;
        Pair(int node , int dis){
            this.node = node;
            this.dis = dis;
        }
        @Override
        public int compareTo(Pair o){
            return this.dis - o.dis;
        }    
    }    

