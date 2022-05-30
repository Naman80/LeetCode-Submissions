class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        
        for(int i = 0 ; i<n+1;i++){
            parent[i] = i;
        }
        int ans = 0;
        for(int i = 0; i<n;i++){
           int u = edges[i][0];
           int v = edges[i][1];
            
            if(findPar(u) != findPar(v))union(u,v);
            else ans = i;
            
        }
        
        return edges[ans];
    }
    
    
    int findPar(int x){
        if(parent[x] == x)return x;
        
        return parent[x] = findPar(parent[x]);
    }
    
    void union(int u,int v){
        
        u = findPar(u);
        v = findPar(v);
        
        if(v!=u){
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
}