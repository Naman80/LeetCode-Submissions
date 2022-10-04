class Solution {
    public boolean equalFrequency(String s) {
        int n = s.length();
        
        int[] map = new int[26];
        
        for(int i = 0 ; i  < n; i++){
            map[s.charAt(i) - 'a']++;
        }
        
        HashMap<Integer , Integer> map2 = new HashMap<>();
        
        for(int x : map){
            if(x==0)continue;
            map2.putIfAbsent(x , 0);
            map2.put(x , map2.get(x)+1);
        }
        
        if(map2.size()>2)return false;
        if(map2.size()== 1){
            for(int x : map2.keySet()){
                if(x == 1 || map2.get(x)==1)return true;
                return false;
            }
        }
        int k1 = 0;
        int k2 = 0;
        int v1 = 0;
        int v2 = 0;
        int i = 0;
        for(int x : map2.keySet()){
           if(i ==0){
               k1 = x;
               v1 = map2.get(x);
           }else{
               k2 = x;
               v2 = map2.get(x);
           }
            i++;
            
        }
        if((k1 == 1 && map2.get(k1)==1) || (k2 == 1 && map2.get(k2)==1) )return true;
        if(Math.abs(k1 - k2)!=1)return false;
        
        if(map2.get(Math.max(k1 , k2))!=1)return false;
        return true;
    }
}