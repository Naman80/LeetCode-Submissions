class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String , Integer> same = new HashMap<>();
        
        HashMap<String , Integer> diff = new HashMap<>();
        int n = words.length;
        int ans = 0;
        for(int i = 0 ; i < n ; i ++){
            
            String temp = words[i];
            
            if(temp.charAt(0) == temp.charAt(1)){
                same.putIfAbsent(temp , 0);
                same.put(temp , same.get(temp)+1);
            }else{
                
                StringBuilder sb = new StringBuilder(temp);
                sb = sb.reverse();
                String foo = String.valueOf(sb);
                if(diff.containsKey(foo)){
                    ans+=4;
                    diff.put(foo , diff.get(foo)-1);
                    if(diff.get(foo)==0)diff.remove(foo);
                    
                }else{
                    diff.putIfAbsent(temp,0);
                    diff.put(temp,diff.get(temp)+1);
                }
            }
            
        }
        boolean odd = false;
        for(String x : same.keySet()){
            int temp = same.get(x);
            ans+= ((temp/2)*2)*2;
            if(temp%2!=0)odd=true;
        }
       if(odd)ans+=2; 
        
        return ans;
        
        
    }
}