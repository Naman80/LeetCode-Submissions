class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character , Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            map.putIfAbsent(ch ,0);
            map.put(ch , map.get(ch)+1);
        }
        
        for(int i = 0 ; i  < t.length() ; i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch))return false;
            else{
                map.put(ch , map.get(ch)-1);
                if(map.get(ch)==0)map.remove(ch);
            }
        }
        
        return map.size()==0;
        
    }
}