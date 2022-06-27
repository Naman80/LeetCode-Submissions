class Solution {
    public int minPartitions(String s) {
        int n = s.length();
        
        int ans = 0;
        
        for(int i  = 0 ;i<n;i++){
            char ch = s.charAt(i);
            int in = Integer.parseInt(String.valueOf(ch));
            ans = Math.max(ans,in);
        }
        
        return ans;
    }
}