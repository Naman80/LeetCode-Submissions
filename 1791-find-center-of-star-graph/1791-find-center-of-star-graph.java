class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0;j<2;j++){
                hm.putIfAbsent(edges[i][j],0);
                hm.put(edges[i][j],hm.get(edges[i][j])+1);
            }
        }
        for(int y : hm.keySet()){
            if(hm.get(y)==2)return y;
        }
        return -1;
    }
}