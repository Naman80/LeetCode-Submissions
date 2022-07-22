class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < n;i++){
            map.put(i,new HashSet<>());
        }
        int[] indeg = new int[n];
        for(int[] x : roads){
            map.get(x[0]).add(x[1]);
            map.get(x[1]).add(x[0]);
            indeg[x[0]]++;
            indeg[x[1]]++;
        }
        int ans = 0;
        for(int i = 0 ;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(map.get(i).contains(j)){
                    ans = Math.max(ans,indeg[i]+indeg[j]-1);
                }else{
                    ans = Math.max(ans,indeg[i] + indeg[j]);
                }
                
                
            }
        }
        
        
        return ans;
        
        
        
    }
}