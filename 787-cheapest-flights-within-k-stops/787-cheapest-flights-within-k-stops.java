class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < n ;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] x: flights){
            Pair p = new Pair(x[1],x[2]);
            adj.get(x[0]).add(p);
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int count = 0;
        Queue<Pair> q = new LinkedList<>();
        dist[src] = 0;
        q.add(new Pair(src , 0));
        while(q.size()!=0){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                Pair out = q.poll();
                int node = out.v;
                int dis = out.dis;
                for(Pair x :adj.get(node)){
                   int v = x.v;
                    int nextdis = x.dis;
                    
                    if(dist[v] > nextdis+dis){
                        dist[v] = nextdis+dis;
                        q.add(new Pair(v , dist[v]));
                    }
                    
                }
                
            }
            count++;
            if(count>k)break;
        }
        if(dist[dst] != Integer.MAX_VALUE)return dist[dst];
        return -1;
        
        
    }
}


class Pair{
    int v;
    int dis;
    Pair(int v , int dis){
        this.v = v;
        this.dis = dis;
    }
}