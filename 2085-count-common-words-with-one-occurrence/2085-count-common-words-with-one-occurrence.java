class Solution {
    public int countWords(String[] words1, String[] words2) {
        
        HashMap<String,Integer> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        for(String x : words1){
            if(hs.contains(x))continue;
            if(hm.containsKey(x)){
                hm.remove(x);
                hs.add(x);
            }else{
                hm.put(x,1);
            }
        }
        for(String x : words2){
            if(hm.containsKey(x)){
                hm.put(x,hm.get(x)+1);
            }
        }
        int ans = 0;
        for(String x : hm.keySet()){
            if(hm.get(x)==2)ans++;
        }
        
        return ans;
        
    }
}