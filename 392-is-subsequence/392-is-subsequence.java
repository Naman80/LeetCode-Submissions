class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        // int[][] dp = new int[slen+1][tlen+1];
        // for(int i = 1 ; i< slen+1 ; i++){
        //     for(int j = 1 ; j< tlen + 1 ;j++){
        //         if(s.charAt(i-1) == t.charAt(j-1)){
        //             dp[i][j] = 1 + dp[i-1][j-1] ;
        //         }else{
        //             dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
        //         }
        //     }
        // }
        // if(dp[slen][tlen] == slen)return true;
        // return false;
        
        
        int count = 0;
        
        int i = 0 ; int j = 0;
        
        while(i<slen && j<tlen){
            
            if(s.charAt(i) == t.charAt(j)){
                count++;
                i++;
            }
            j++;
            
        }
        
        return count==slen;
    }
    
    
}