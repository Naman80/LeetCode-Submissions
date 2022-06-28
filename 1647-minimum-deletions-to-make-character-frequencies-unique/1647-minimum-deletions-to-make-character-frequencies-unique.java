class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        int[] map = new int[26];
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i= 0;i<n;i++){
            char ch = s.charAt(i);
            map[ch-'a']++; 
        }
        for(int i = 0;i<26;i++){
            if(map[i]==0)continue;
            hm.putIfAbsent(map[i],0);
            hm.put(map[i],hm.get(map[i])+1);
        }
        int sum = 0;
        for(int i = 0;i<26;i++){
            
            if(map[i]==0)continue;
            if(hm.get(map[i])>1){
                int nkey = map[i]-1;
                sum++;
                while(hm.containsKey(nkey)){
                    nkey--;sum++;
                }
                if(nkey!=0)hm.put(nkey,1);
                hm.put(map[i],hm.get(map[i])-1);
                
            }
            
        }
        
        return sum;
        
    }
}