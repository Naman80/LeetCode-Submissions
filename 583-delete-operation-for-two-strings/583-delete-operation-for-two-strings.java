class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] dp = new int[m+1];
        for(int i = 0;i< n+1 ;i++){
            int[] temp = new int[m+1];
            for(int j = 0;j<m+1;j++){
                if (i == 0 || j == 0){
                    temp[j]  = i+j;continue;
                }
                char ch1 = word1.charAt(i-1);
                char ch2 = word2.charAt(j-1);
                if(ch1 == ch2){
                    temp[j] = dp[j-1];
                }else{
                    temp[j] = 1 + Math.min(dp[j],temp[j-1]);
                }
            }
            
            dp = temp;
        }
       return dp[m];
    }
}