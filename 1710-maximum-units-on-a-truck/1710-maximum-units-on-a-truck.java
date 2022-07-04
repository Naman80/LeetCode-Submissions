class Solution {
    public int maximumUnits(int[][] bT, int tS) {
        Arrays.sort(bT,Comparator.comparingInt((a) -> -a[1]));
        
        int ans =0;
        int n = bT.length;
        for(int i = 0;i<n;i++){
            if(tS<=0)break;
            int min = Math.min(bT[i][0],tS);
            ans+= (min*bT[i][1]);
            tS-=min;
        }
        return ans;
    }
}