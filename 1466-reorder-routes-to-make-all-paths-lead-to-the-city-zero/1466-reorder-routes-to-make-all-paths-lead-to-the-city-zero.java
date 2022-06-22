class Solution {
    int ans = 0;
    int[] parent;
    public int minReorder(int n, int[][] c) {
        
       ArrayList<ArrayList<Integer[]>> adj = new ArrayList<>();
        
        for(int i = 0 ; i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] x : c){
            adj.get(x[0]).add(new Integer[]{x[1],1});
            adj.get(x[1]).add(new Integer[]{x[0],0});
        }
//         for(int i = 0 ; i < n;i++){
//            Collections.sort(adj.get(i));
//         }
        
//         parent = new int[n];
//         for(int i = 0 ; i < n;i++){
//             parent[i] = i;
//         }
//         for(int i = 0 ; i < n;i++){
//             for(int x : adj.get(i)){
//                 union(i,x);
//             }
//         }
        
        boolean[] vis = new boolean[n];
        
        for(int i = 0 ; i < n;i++){
            if(!vis[i]){
                dfs(i,adj,vis);
            }
        }
        return ans;
    }
    
//     int find(int x){
//         if(parent[x] == x)return x;
//         return parent[x] = find(parent[x]);
//     }
    
//     void union(int u , int v){
        
//         u = find(u);
//         v = find(v);
        
//         if(v==0){
//             parent[u] = v; 
//         }else{
//             ans++;
//             parent[v] = u;
//         }
        
//     }
    
    void dfs(int v , ArrayList<ArrayList<Integer[]>> adj , boolean[] vis){
        vis[v] = true;
       
        for(Integer[] x : adj.get(v)){
            if(!vis[x[0]]){
                if(x[1]==1)ans++;
                dfs(x[0],adj,vis);
            }
        }
        
    }
}