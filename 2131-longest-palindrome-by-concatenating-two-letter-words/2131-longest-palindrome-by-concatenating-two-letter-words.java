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
                diff.putIfAbsent(temp , 0);
                diff.put(temp , diff.get(temp)+1);
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            StringBuilder sb = new StringBuilder(words[i]);
            sb = sb.reverse();
            String temp = String.valueOf(sb);
               if(diff.containsKey(temp)){
                   ans+= ((int)Math.min(diff.get(words[i]) , diff.get(temp)) * 2)*2;
                   diff.remove(words[i]);
                   diff.remove(temp);
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