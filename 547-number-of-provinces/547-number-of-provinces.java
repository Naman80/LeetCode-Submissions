class Solution {
    int[] parent;
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        
         parent = new int[n];
        for(int i = 1 ;i< n ;i++){
            parent[i] = i;
        }
        for(int i = 0 ; i < n ; i++){
            for(int  j = 0 ; j < n;j++){
                if(i==j)continue;
                if(isConnected[i][j] == 1){
                    union(i,j);
                }
            }
        }
        
        int ans = 0;
        
        for(int i = 0 ; i < n;i++){
            if(parent[i]==i)ans++;
        }
        
        return ans;
        
    }
    
    
    int findpar(int x){
        if(parent[x]==x)return x;
        
        return parent[x] = findpar(parent[x]);
    }
    
    void union(int u , int v){
        
        int up = findpar(u);
        int vp = findpar(v);
        
        if(up!=vp){
            parent[up] = vp;
        }
    }
}