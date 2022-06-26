class Solution {
    public int countHousePlacements(int n) {
        int mod = 1000000007;
        long[] store = new long[n+1];
        store[0] = 1;
        store[1] = 2;
        
        for(int i = 2;i<n+1;i++){
            store[i] = ((store[i-1]) + (store[i-2]))%mod;
        }
        
        return (int)(store[n]%mod * store[n]%mod)%mod;
        
    }
}