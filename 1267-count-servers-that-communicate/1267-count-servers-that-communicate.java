class Solution {
    int[] parent;
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        HashMap<Integer,ArrayList<Integer>> row = new HashMap<>();      
        int count = 1;
        for(int i = 0 ; i < n ; i++){
            row.put(i,new ArrayList<>());
            for(int j = 0 ;  j < m ;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = count;
                    count++;
                    row.get(i).add(grid[i][j]);
                }
            }
        }
        HashMap<Integer,ArrayList<Integer>> col = new HashMap<>();
        for(int j = 0 ; j < m ;j++){
            col.put(j,new ArrayList<>());
            for(int i = 0 ; i < n ; i++){
                if(grid[i][j] >0){
                    col.get(j).add(grid[i][j]);
                }
            }
        }
        parent = new int[count];
        // System.out.println(row);
        
        // System.out.println(col);
        for(int i = 1 ;i<count;i++){
            parent[i] = i;
        }
        for(ArrayList<Integer> x : row.values()){
            if(x.size()>=2){
                for(int i = 1 ; i < x.size();i++){
                    union(x.get(i-1),x.get(i));
                }
            }
        } 
        
        for(ArrayList<Integer> x : col.values()){
            if(x.size()>=2){
                for(int i = 1 ; i < x.size();i++){
                    union(x.get(i-1),x.get(i));
                }
            }
        } 
        
        for(int i = 1;i<count;i++){
            int x = findpar(i);
        }
        
        // System.out.println(Arrays.deepToString(parent));
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int x : parent){
            hm.putIfAbsent(x,0);
            hm.put(x,hm.get(x)+1);
        }
        
        
        int ans = 0;
        for(int x : hm.keySet()){
            if(hm.get(x)>1)ans+=hm.get(x);
        }
        
        return ans;
        
        
    }
    
    
    int findpar(int x){
        if(parent[x] == x)return x;
        
        return parent[x] = findpar(parent[x]);
    }
    
    void union(int u , int v){
        
        u = findpar(u);
        v = findpar(v);
        
        parent[v] = u;
        
    }
    
    
}