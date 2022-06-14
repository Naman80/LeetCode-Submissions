class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        
        int n = t1.length();
        int m = t2.length();
        
        int[] dp = new int[m+1];
        
        for(int i = 1;i<n+1;i++){
            int[] temp = new int[m+1];
            for(int j = 1;j<m+1;j++){
                char ch = t1.charAt(i-1);
                char ch1 = t2.charAt(j-1);
                if(ch == ch1){
                    temp[j] = 1 + dp[j-1];
                }else{
                    temp[j] = Math.max(temp[j-1],dp[j]);
                }
            }
            
            dp = temp;
        }
        return dp[m];

    }
}