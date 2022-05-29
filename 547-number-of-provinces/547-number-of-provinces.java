class Solution {
    
    int[] parent;
    
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        parent = new int[n];
        
        for(int i =0;i<n;i++){
            parent[i] = i;
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0 ; j<n;j++){
                if(i!=j && adj[i][j] == 1){
                    union(i,j);
                }
            }
        }
        
        int com = 0;
        for(int i = 0;i<n;i++){
            if(parent[i] == i)com++;
        }
        return com;
    }
    
    int findPar(int x){
        if(parent[x]==x)return x;
        return parent[x] = findPar(parent[x]);
    }
    
    void union(int u , int v){
        
        int up = findPar(u);
        int vp = findPar(v);
        
        if(vp!=up){
            parent[vp] = up;
        }
        
    }
}