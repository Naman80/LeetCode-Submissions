class Solution {
     public int longestStrChain(String[] words) {

        int n = words.length;
        Integer[] dp = new Integer[n+1];
        Arrays.sort(words , Comparator.comparingInt(String::length));
        // System.out.println(Arrays.toString(words));
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans,solve(i,words,dp));
        }
        return ans;
    }
    int solve(int i,String[] words,Integer[] dp){
        if(dp[i]!=null) return dp[i];
        String s = words[i];
        int slen = s.length();
        dp[i] = 1;
        for(int j = i+1 ; j <words.length;j++) {
            if (words[j].length() - 1 == slen) {
                if (lcs(s,words[j])==slen){
                    int temp = 1 + solve(j,words,dp);
                    dp[i]= Math.max(dp[i],temp);
                }
            }
        }
        return dp[i];
    }
    int lcs(String s, String word) {
        int n = s.length();int m = word.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i==0 || j==0)continue;
                if (s.charAt(i-1) == word.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}