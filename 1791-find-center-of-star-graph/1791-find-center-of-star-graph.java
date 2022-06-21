class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = edges.length;
        // for(int[] x : edges){
        //     for(int y : x){
        //         hm.putIfAbsent(y,0);
        //         hm.put(y,hm.get(y)+1);
        //     }
        // }
        
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0;j<2;j++){
                hm.putIfAbsent(edges[i][j],0);
                hm.put(edges[i][j],hm.get(edges[i][j])+1);
            }
        }
        Set<Integer> x= hm.keySet();
        
        // return 1;
        for(int y : x){
            if(hm.get(y)==2)return y;
        }
        return -1;
        
    }
}