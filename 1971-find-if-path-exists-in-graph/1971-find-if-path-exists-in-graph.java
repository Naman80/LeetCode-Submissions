class Solution {
    int[] parent;
    int[] rank;
    public boolean validPath(int n, int[][] e, int s, int d) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ;i<n;i++){
            parent[i] = i;
        }
        for(int i = 0 ;i<e.length;i++){
            
            union(e[i][0],e[i][1]);
        }
        
        if(findPar(s) == findPar(d))return true;
        return false;
    }
    
    int findPar(int x){
        if(parent[x]==x)return x;    
        return parent[x] = findPar(parent[x]);
    }
    
    
    void union(int u,int v){
        u = findPar(u);
        v = findPar(v);
        if(u!=v){
            
            if(rank[u] > rank[v]){
                parent[v] = u;
            }else if(rank[v] > rank[u]){
                parent[u] = v;
            }else{
                parent[u] = v;
                rank[v]++;
            }
            
        }
    }
    
    
}