class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int n = s.length();
        HashMap<Character , Integer> map = new HashMap<>();
        long[] dp = new long[n+1];
        dp[0] =1;
        for(int i = 1; i < n+1 ; i++){
            dp[i] = (2%mod * dp[i-1]%mod)%mod;
            char ch = s.charAt(i-1);
            if(map.containsKey(ch)){
                dp[i] = (dp[i]%mod -  dp[map.get(ch)-1]%mod + mod)%mod;
            }
            map.put(ch , i);   
        }
        return (int)dp[n]-1;
    }
}