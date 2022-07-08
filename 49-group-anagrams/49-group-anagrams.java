class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    
        HashMap<String , List<String>> hm = new HashMap<>();
        
        for(int i = 0 ; i < strs.length ; i++){
            
            String ori = strs[i];
            
            String dup = ori;
            char tempArray[] = dup.toCharArray();
 
        // Sorting temp array using
            Arrays.sort(tempArray);
 
        // Returning new sorted string
            dup =  new String(tempArray);
            
            
            if(hm.containsKey(dup)){
                hm.get(dup).add(ori);
            }else{
                hm.put(dup , new ArrayList<>());
                hm.get(dup).add(ori);
            }
            
            
        }
        
       List<List<String>> ans = new ArrayList<>();
        
        // for(int i = 0 ; i < hm.size();i++){
        //     ans.add(new ArrayList<>());
        //     // System.out.println(ans.get(i));
        // }
        // int i = 0;
        // for(String x : hm.keySet()){
        //     ans.get(i) = new ArrayList<>(hm.get(x));
        //     i++;
        // }
        
        for(List<String> al : hm.values()){
            ans.add(new ArrayList<>(al));
        }
        
        return ans;
        
        
    }
}