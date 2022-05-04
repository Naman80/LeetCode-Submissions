class Solution {
    public int maxOperations(int[] nums, int k) {
     HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int c:nums){
            if(!hm.containsKey(c)){
                hm.putIfAbsent(c,1);
            }else{
                hm.put(c,hm.get(c)+1);
            }
        }
        int ans = 0;
        for(int x:nums){
            if(hm.get(x)==0)continue;
            if(k-x>0){
            int diff = k - x;
            hm.put(x,hm.get(x)-1);
            if(hm.containsKey(diff) && hm.get(diff)>0){
                ans++;
                hm.put(diff,hm.get(diff)-1);
            }
            }
        }
        return ans;
    }
}