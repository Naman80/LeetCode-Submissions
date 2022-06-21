class Solution {
    int[] parent;
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        parent = new int[n];
        for(int i = 0 ;i<n;i++){
            parent[i] = i;
        }
        
        List<Integer> al = new ArrayList<>();
        
        for(List<Integer> x : edges){
            int u = x.get(0);
            int v = x.get(1);
            union(u,v);
        }
        
        
        for(int i = 0 ;i<n;i++){
            if(parent[i] == i){
                al.add(i);
            }
        }
        
        return al;
        
        
        
    }
    
    
    int find(int x){
        if(parent[x] == x)return x;
        
        return parent[x] = find(parent[x]);
    }
    void union(int u ,int v){
        
        int up = find(u);
        int vp = find(v);
        // System.out.println(u + " " + v);
        if(vp==v)
            parent[vp] = up;
        
    }
}