class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = edges.length;
        for(int[] x : edges){
            for(int y : x){
                hm.putIfAbsent(y,0);
                hm.put(y,hm.get(y)+1);
            }
        }
        Set<Integer> x= hm.keySet();
        
        // return 1;
        for(int y : x){
            if(hm.get(y)==n)return y;
        }
        return -1;
        
    }
}