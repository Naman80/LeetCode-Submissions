class Solution {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen  = t.length();
        HashMap<Character , Integer> map2 = new HashMap<>();
        for(int  i = 0 ; i < tlen;i++){
            char ch = t.charAt(i);
            map2.putIfAbsent(ch,0);
            map2.put(ch,map2.get(ch)+1);
        }
        int count = 0;
        int i = -1;
        int j = -1;
        HashMap<Character , Integer> map1  = new HashMap<>();
        
        String ans = "";
        while(true){
            
            boolean f1 = true;
            boolean f2 = true;
            
            // add elements to map1
            while( j < slen-1 && count < tlen){
                j++;
                char ch = s.charAt(j);
                map1.put(ch, map1.getOrDefault(ch,0) + 1);
                if(map2.containsKey(ch) && map1.get(ch) <= map2.get(ch)){
                    count++;
                }
                f1 = false;
            }
            
            // collect ans and delete 
            while( i < j && count == tlen){
                i++;
                String temp = s.substring(i,j+1);
                if(ans == "" || ans.length() > temp.length()){
                    ans = temp;
                }
                char ch = s.charAt(i);
                
                if(map1.get(ch)==1){
                    map1.remove(ch);
                }else{
                    map1.put(ch,map1.get(ch)-1);
                }
                
                if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0)){
                    count--;
                }
                f2 = false;
            }
            
            if(f1 && f2)break;
            
            
        }
        
        
        return ans;
        
        
    }
}