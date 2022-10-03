class Solution {
    public int minCost(String s, int[] time) {
        int n = s.length();
        if(n==1)return 0;
        int ans = 0;
        int max = 0;
        int smax = 0;
        int i = 1;
        char prev = s.charAt(0);
        max = time[0];
        while(i < n){
            
           if(prev == s.charAt(i)){
                smax = time[i];
                ans+=Math.min(max , smax);
                max = Math.max(max , smax);
           }else{
               prev = s.charAt(i);
               max = time[i];
           }
            i++;
        }
        
        return ans;
        
    }
}