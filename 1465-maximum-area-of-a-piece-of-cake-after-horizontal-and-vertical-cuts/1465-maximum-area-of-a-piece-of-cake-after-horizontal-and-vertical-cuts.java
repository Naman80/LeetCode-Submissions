class Solution {
    public int maxArea(int h, int w, int[] hC, int[] vC) {
        int mod = 1000000007;
        Arrays.sort(hC);
        Arrays.sort(vC);
        int n = hC.length;
        int m = vC.length;
        long l = hC[0];
        long sl = vC[0];
        for(int i = 1 ; i < n;i++){
            l = Math.max(l,(hC[i] - hC[i-1]));
        }
        l = Math.max(l,(h-hC[n-1]));
        for(int i = 1;i<m;i++){
           sl = Math.max(sl,(vC[i] - vC[i-1]));
        }
        sl = Math.max(sl,(w - vC[m-1]));
        return (int)((l*sl)%mod);
    }
}