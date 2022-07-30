class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
      HashMap<Character,Integer> map1 = new HashMap<>();
      HashMap<Character,Integer> maptemp ;
        
        
        for(String x : words2){
            HashMap<Character,Integer> temp = new HashMap<>();
            for(char ch : x.toCharArray()){
                temp.putIfAbsent(ch , 0);
                temp.put(ch,temp.get(ch)+1);
            }
            for(char ch : temp.keySet()){
                if(map1.containsKey(ch)){
                    int max = Math.max(temp.get(ch) , map1.get(ch));
                    map1.put(ch, max);
                }else{
                    map1.put(ch , temp.get(ch));
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(String x : words1){
            maptemp = new HashMap<>(map1);
            for(char ch : x.toCharArray()){
                if(maptemp.containsKey(ch)){
                    maptemp.put(ch , maptemp.get(ch)-1);
                    if(maptemp.get(ch)==0){
                        maptemp.remove(ch);
                    }
                }
            }
            if(maptemp.size()==0)ans.add(x);
            
        }
        
        return ans;
    }
}